package ir.viratech.pond_ms.api.review;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.SimpleTabularCollectionDTO_NoFieldInfo;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.model.ListAndTotalCount;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.PaginationParam;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO;
import ir.viratech.pond_ms.api.review.dto.*;
import ir.viratech.pond_ms.api.user.dto.UserReviewDTO;
import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModel;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.review.ReplyReview;
import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.logic.ReplyReviewMgr;
import ir.viratech.pond_ms.model.review.logic.ReviewMgr;
import ir.viratech.pond_ms.model.review.logic.ReviewVoteMgr;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;
import ir.viratech.pond_ms.model.user.logic.UserMgr;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Path("/review")
public class ReviewService extends AbstractJsonService {

    @GET
    @Path("/all/waitingforconfirm")
    public Response getReviews(@BeanParam PaginationParam paginationParam) {
        ListAndTotalCount<Review> reviews = ReviewMgr.getInstance().pageList_waitingForConfirmation(paginationParam.getStart(), paginationParam.getLen());
        SimpleTabularCollectionDTO_NoFieldInfo<ReviewFullDTO> dto = new SimpleTabularCollectionDTO_NoFieldInfo();
        Collection<ReviewFullDTO> collectionDTO = DtoUtil.convertCollection(reviews.getItems(), ReviewFullDTO.class);
        dto.loadFrom(collectionDTO, reviews.getTotalCount());
        return Response.ok(dto).build();
    }

    @GET
    @Path("/all/waiting-for-confirm-web")
    public Response getReviewsWeb(@BeanParam PaginationParam paginationParam) {
        ObjectNode finalResult = JacksonUtils.createEmptyObjectNode();
        ArrayNode items = JacksonUtils.createEmptyArrayNode();
        ListAndTotalCount<Review> reviews = ReviewMgr.getInstance().pageList_waitingForConfirmation(paginationParam.getStart(), paginationParam.getLen());
        SimpleTabularCollectionDTO_NoFieldInfo<ReviewFullDTO> dto = new SimpleTabularCollectionDTO_NoFieldInfo();
        Collection<ReviewFullDTO> collectionDTO = DtoUtil.convertCollection(reviews.getItems(), ReviewFullDTO.class);
        for (ReviewFullDTO reviewFullDTO : collectionDTO) {
            ObjectNode item = JacksonUtils.createEmptyObjectNode();
            ReviewFullDTO next = reviewFullDTO;
            item.put("uid", next.getUid());
            item.put("title", next.getTitle());
            item.put("rate", next.getRate());
            item.put("text", next.getText());
            item.put("creationDate", next.getCreationDate());
            item.put("visitedDate", next.getVisitedDate());
            item.put("typeOfVisit", next.getTypeOfVisit());
            item.put("confirmed", next.getConfirmed());
            item.put("deleted", next.isDeleted());
            item.put("voteUpCount", next.getVoteUpCount());
            item.put("voteDownCount", next.getVoteDownCount());
            PlainCollectionDTO<ReplyReview, ReplyReviewFullDTO> replies = next.getReplies();
            item.put("replies", ObjectMapperProvider.getObjectMapper().valueToTree(replies));
            UserReviewDTO user = next.getUser();
            item.put("user", ObjectMapperProvider.getObjectMapper().valueToTree(user));
            GISVectorObjectFullDTO gisVectorObject = next.getGisVectorObject();
            EntityInstance formInstance = gisVectorObject.getFormInstance();
            ObjectNode data = formInstance.getData();
            String entityTypeKey = formInstance.getEntityTypeKey();
            data.put("__type", entityTypeKey);
            JsonNode jsonNode = GisVectorLayerToNewModel.mapperToNewModel(data);
            item.put("place", jsonNode);
            items.add(item);
        }
        finalResult.put("totalCount", reviews.getTotalCount());
        finalResult.put("items", items);
        return Response.ok(finalResult).build();
    }


    @GET
    @Path("/gis-vector-object/{uid}")
    public Response getReviewsByObjectUid(@BeanParam PaginationParam paginationParam, @PathParam("uid") String objectUid) {
        GISVectorObject object = GISVectorObjectMgr.getInstance().getByExtuid(objectUid);
        List<Review> reviews = ReviewMgr.getInstance().getConfirmedByGisVectorObject(object, paginationParam.getStart(), paginationParam.getLen());
        long totalCount = ReviewMgr.getInstance().getCountConfirmedByGisVectorObject(object);
        float avgRate = ReviewMgr.getInstance().getAvgConfirmedByGisVectorObject(object);
        Collection<ReviewViewDTO> collectionDto = DtoUtil.convertCollection(reviews, ReviewViewDTO.class);
        GISVectorObjectReviewsDTO<ReviewViewDTO> dto = new GISVectorObjectReviewsDTO<>();
        dto.loadFrom(collectionDto, totalCount, avgRate);
        return Response.status(200).entity(dto).build();
    }

    @POST
    @Path("/gis-vector-object/{uid}")
    public Response addReviewToGisVectorObject(@PathParam("uid") String gisVectorObjectUid,
                                               @RequestBody ReviewSaveDTO reviewSaveDTO) {
        Review review = DtoUtil.saveDtoAndGetObject(reviewSaveDTO, ReviewMgr.getInstance().createNew());
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        GISVectorObject gisVectorObject = GISVectorObjectMgr.getInstance().getByExtuid(gisVectorObjectUid);
        ReviewMgr.getInstance().addReview(gisVectorObject, review, user);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/{uid}/reply")
    public Response replyToReview(@PathParam("uid") String reviewUid,
                                  @RequestBody ReplyReviewSaveDTO replyReviewSaveDTO) {

        Review review = ReviewMgr.getInstance().getByExtuid(reviewUid);
        if (review != null) {
            ReplyReview replyReview = DtoUtil.saveDtoAndGetObject(replyReviewSaveDTO, ReplyReviewMgr.getInstance().createNew());
            ReviewMgr.getInstance().replyToReview(review, replyReview);
        } else {
            return Response.status(400).entity("Review not found").build();
        }
        return Response.status(200).build();
    }


    @POST
    @Path("{uid}/voteup")
    public void voteUp(@PathParam("uid") String reviewUid, ReviewVoteDTO reviewVoteDTO) {
        Review review = ReviewMgr.getInstance().getByExtuid(reviewUid);
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        ReviewVoteMgr.getInstance().voteUp(review, user);
    }


    @POST
    @Path("{uid}/votedown")
    public void voteDown(@PathParam("uid") String reviewUid, ReviewVoteDTO reviewVoteDTO) {
        Review review = ReviewMgr.getInstance().getByExtuid(reviewUid);
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        ReviewVoteMgr.getInstance().voteDown(review, user);
    }

    @GET
    @Path("/user")
    public Response getReviewsByUserUid(@BeanParam PaginationParam paginationParam, @QueryParam("userUid") String userUid) {
        User user = UserMgr.getInstance().getByExtuid(userUid);
        if (user == null)
            return Response.status(400).entity("User not found").build();
        List<Review> reviews = ReviewMgr.getInstance().getConfirmedByUser(user, paginationParam.getStart(), paginationParam.getLen());
        SimpleTabularCollectionDTO_NoFieldInfo<ReviewLightDTO> responseDto = new SimpleTabularCollectionDTO_NoFieldInfo<ReviewLightDTO>();
        Collection<ReviewLightDTO> collectionDto = DtoUtil.convertCollection(reviews, ReviewLightDTO.class);
        long count = ReviewMgr.getInstance().getCountConfirmedByUser(user);
        responseDto.loadFrom(collectionDto, count);
        return Response.status(200).entity(responseDto).build();
    }

    @GET
    @Path("/user_web")
    public Response getReviewsByUserUidNewModel(@BeanParam PaginationParam paginationParam, @QueryParam("userUid") String userUid) {
        ObjectNode finalResult = JacksonUtils.createEmptyObjectNode();
        ArrayNode items = JacksonUtils.createEmptyArrayNode();
        User user = UserMgr.getInstance().getByExtuid(userUid);
        if (user == null) {
            return Response.status(400).entity("User not found").build();
        }
        List<Review> reviews = ReviewMgr.getInstance().getConfirmedByUser(user, paginationParam.getStart(), paginationParam.getLen());
        Collection<ReviewLightDTO> collectionDto = DtoUtil.convertCollection(reviews, ReviewLightDTO.class);
        for (ReviewLightDTO reviewLightDTO : collectionDto) {
            ObjectNode item = JacksonUtils.createEmptyObjectNode();
            ReviewLightDTO next = reviewLightDTO;
            item.put("uid", next.getUid());
            item.put("title", next.getTitle());
            item.put("rate", next.getRate());
            item.put("text", next.getText());
            item.put("creationDate", next.getCreationDate());
            item.put("visitedDate", next.getVisitedDate());
            GISVectorObjectFullDTO gisVectorObject = next.getGisVectorObject();
            EntityInstance formInstance = gisVectorObject.getFormInstance();
            ObjectNode data = formInstance.getData();
            String entityTypeKey = formInstance.getEntityTypeKey();
            data.put("__type", entityTypeKey);
            JsonNode jsonNode = GisVectorLayerToNewModel.mapperToNewModel(data);
            item.put("place", jsonNode);
            PlainCollectionDTO<ReplyReview, ReplyReviewViewDTO> replies = next.getReplies();
            item.put("replies", ObjectMapperProvider.getObjectMapper().valueToTree(replies));
            items.add(item);
        }
        long count = ReviewMgr.getInstance().getCountConfirmedByUser(user);
        finalResult.put("totalCount", count);
        finalResult.put("items", items);
        return Response.ok(finalResult).build();
    }


    @POST
    @Path("{uid}/confirm")
    public void confirmReview(@PathParam("uid") String reviewUid) {
        AccessChecker.checkAccess(Feature.EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.REVIEW));
        Review review = ReviewMgr.getInstance().getByExtuid(reviewUid);
        if (review == null)
            throw new ResponseException(Response.status(404).entity("Review not found").build());
        String uid = review.getGisVectorObject().getExtuid();
        GISVectorObjectMgr.getInstance().incReviewCountToObject(uid);
        ReviewMgr.getInstance().confirm(review);
    }

    @POST
    @Path("{uid}/unconfirm")
    public void unConfirmReview(@PathParam("uid") String reviewUid) {
        AccessChecker.checkAccess(Feature.EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.REVIEW));
        Review review = ReviewMgr.getInstance().getByExtuid(reviewUid);
        if (review == null)
            throw new ResponseException(Response.status(404).entity("Review not found").build());
        String uid = review.getGisVectorObject().getExtuid();
        GISVectorObjectMgr.getInstance().decReviewCountToObject(uid);
        ReviewMgr.getInstance().unConfirm(review);
    }

    @GET
    @Path("/myreviews")
    public Response getReviewsByCurrentUser(@BeanParam PaginationParam paginationParam) {
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        List<Review> reviews = ReviewMgr.getInstance().getAllByUser(user, paginationParam.getStart(), paginationParam.getLen());
        SimpleTabularCollectionDTO_NoFieldInfo<ReviewLightDTO> responseDto = new SimpleTabularCollectionDTO_NoFieldInfo<ReviewLightDTO>();
        Collection<ReviewLightDTO> collectionDto = DtoUtil.convertCollection(reviews, ReviewLightDTO.class);
        long count = ReviewMgr.getInstance().getCountConfirmedByUser(user);
        responseDto.loadFrom(collectionDto, count);
        return Response.status(200).entity(responseDto).build();
    }

    @GET
    @Path("/my-reviews-web")
    public Response getReviewsByCurrentUserWeb(@BeanParam PaginationParam paginationParam) {
        ObjectNode finalResult = JacksonUtils.createEmptyObjectNode();
        ArrayNode items = JacksonUtils.createEmptyArrayNode();
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        List<Review> reviews = ReviewMgr.getInstance().getAllByUser(user, paginationParam.getStart(), paginationParam.getLen());
        SimpleTabularCollectionDTO_NoFieldInfo<ReviewLightDTO> responseDto = new SimpleTabularCollectionDTO_NoFieldInfo<ReviewLightDTO>();
        Collection<ReviewLightDTO> collectionDto = DtoUtil.convertCollection(reviews, ReviewLightDTO.class);
        for (ReviewLightDTO reviewLightDTO : collectionDto) {
            ObjectNode item = JacksonUtils.createEmptyObjectNode();
            ReviewLightDTO next = reviewLightDTO;
            item.put("uid", next.getUid());
            item.put("title", next.getTitle());
            item.put("rate", next.getRate());
            item.put("text", next.getText());
            item.put("creationDate", next.getCreationDate());
            item.put("visitedDate", next.getVisitedDate());
            item.put("visitType", next.getVisitType());
            GISVectorObjectFullDTO gisVectorObject = next.getGisVectorObject();
            EntityInstance formInstance = gisVectorObject.getFormInstance();
            ObjectNode data = formInstance.getData();
            String entityTypeKey = formInstance.getEntityTypeKey();
            data.put("__type", entityTypeKey);
            JsonNode jsonNode = GisVectorLayerToNewModel.mapperToNewModel(data);
            item.put("place", jsonNode);
            PlainCollectionDTO<ReplyReview, ReplyReviewViewDTO> replies = next.getReplies();
            item.put("replies", ObjectMapperProvider.getObjectMapper().valueToTree(replies));
            items.add(item);
        }
        finalResult.put("totalCount", ReviewMgr.getInstance().getCountConfirmedByUser(user));
        finalResult.put("items", items);
        return Response.status(200).entity(finalResult).build();
    }

    @GET
    @Path("newreviewscount")
    public JsonNode getNumbrOfNewReviewsSinceLastSeenTime() {
        AccessChecker.checkAccess(Feature.EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.REVIEW));
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        long reviewCount = ReviewMgr.getInstance().getNewReviewsCountAndUpdateLastSeen(user);
        ObjectNode result = ObjectMapperProvider.getObjectMapper().createObjectNode();
        result.put("reviewCount", reviewCount);
        return result;
    }

    @GET
    @Path("/reviewInc")
    public Response reviewUp(@QueryParam("uid") String uid) {
        try {
            int beforeReviewCount = GISVectorObjectMgr.getInstance().getByExtuid(uid).getReviewCount();
            GISVectorObjectMgr.getInstance().incReviewCountToObject(uid);
            int nextReviewCount = GISVectorObjectMgr.getInstance().getByExtuid(uid).getReviewCount();
            if (nextReviewCount > beforeReviewCount)
                return Response.ok().entity("review count added successfully!").build();
            else
                return Response.status(400).entity("can not find uid!").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("can not find uid!").build();
        }
    }

    @GET
    @Path("/unConfirmed")
    public Response unConfirmed(@QueryParam("start") int start, @QueryParam("len") int len) {
        try {
            if (len == 0)
                len = 10;
            List<Review> unConfirmedReviews = ReviewMgr.getInstance().getUnConfirmedReviews(start, len);
            Collection<ReviewFullDTO> collectionDto = DtoUtil.convertCollection(unConfirmedReviews, ReviewFullDTO.class);
            return Response.ok().entity(collectionDto).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("failed...").build();
        }
    }

    @GET
    @Path("/confirmed")
    public Response confirmed(@QueryParam("start") int start, @QueryParam("len") int len) {
        try {
            if (len == 0)
                len = 10;
            List<Review> confirmedReviews = ReviewMgr.getInstance().getConfirmedReviews(start, len);
            Collection<ReviewFullDTO> collectionDto = DtoUtil.convertCollection(confirmedReviews, ReviewFullDTO.class);
            return Response.ok().entity(collectionDto).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("failed...").build();
        }
    }

    @GET
    @Path("/newReview")
    public Response newReview(@QueryParam("start") int start, @QueryParam("len") int len) {
        try {
            if (len == 0)
                len = 10;
            List<Review> newReviews = ReviewMgr.getInstance().getNewReviews(start, len);
            Collection<ReviewFullDTO> collectionDto = DtoUtil.convertCollection(newReviews, ReviewFullDTO.class);
            return Response.ok().entity(collectionDto).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("failed...").build();
        }
    }
}
