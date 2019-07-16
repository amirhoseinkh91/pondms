package ir.viratech.mongo.model.search;

import java.util.Collection;

import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import ir.viratech.commons.model.order.OrderDirection;
import ir.viratech.commons.model.order.OrderEntry;
import ir.viratech.commons.model.search.SearchCriterion;
import ir.viratech.commons.model.search.criterion.FieldInCollectionRestriction;
import ir.viratech.commons.model.search.criterion.FieldRangeRestriction;
import ir.viratech.commons.model.search.criterion.InterFieldsRestriction;
import ir.viratech.commons.model.search.criterion.RestrictionOperator;
import ir.viratech.commons.model.search.criterion.SingleFieldValueRestriction;
import ir.viratech.commons.model.search.criterion.StringRestriction;

public class SearchConverter {

	private static final transient Logger logger = Logger.getLogger(SearchConverter.class);

	public static Sort convert(OrderEntry orderEntry) {
		return new Sort(orderEntry.getOrderDirection() == OrderDirection.ASCENDING ? Sort.Direction.ASC : Sort.Direction.DESC, orderEntry.getOrderKey());
	}

	protected static CriteriaDefinition convert_(SingleFieldValueRestriction<?> simpleRestriction) {
		RestrictionOperator op = simpleRestriction.getOperator();
		Object val = simpleRestriction.getValue();
		String prop = simpleRestriction.getField();
		if (logger.isDebugEnabled()) {
			logger.debug("prop: " + prop);
		}
		switch (op) {
		case EQ:
			return Criteria.where(prop).is(val);
		case NE:
			return Criteria.where(prop).ne(val);
		case GE:
			return Criteria.where(prop).gte(val);
		case GT:
			return Criteria.where(prop).gt(val);
		case LE:
			return Criteria.where(prop).lte(val);
		case LT:
			return Criteria.where(prop).lt(val);
		}

		throw new IllegalStateException("Unknown SingleFieldValueRestriction operator: " + op);
	}

	protected static CriteriaDefinition convert_(StringRestriction stringRestriction) {
		String val = stringRestriction.getValue();
		String prop = stringRestriction.getField();
		if (logger.isDebugEnabled()) {
			logger.debug("prop: " + prop);
		}
		return Criteria.where(prop).regex(val);
	}

	protected static CriteriaDefinition convert_(FieldRangeRestriction<?> rangeRestriction) {
		Object value_Low = rangeRestriction.getValue_Low();
		Object value_High = rangeRestriction.getValue_High();
		String prop = rangeRestriction.getField();
		if (logger.isDebugEnabled()) {
			logger.debug("prop: " + prop);
		}
		return Criteria.where(prop).gt(value_Low).lt(value_High);
	}

	protected static CriteriaDefinition convert_(InterFieldsRestriction interFieldsRestriction) {
		RestrictionOperator op = interFieldsRestriction.getOperator();
		throw new IllegalStateException("Unknown InterFieldsRestriction operator: " + op);
	}

	protected static CriteriaDefinition convert_(FieldInCollectionRestriction<?> restriction) {
		Collection<?> collection = restriction.getCollection();
		String prop = restriction.getField();
		if (logger.isDebugEnabled()) {
			logger.debug("prop: " + prop);
		}
		return Criteria.where(prop).in(collection);
	}

	@SuppressWarnings("rawtypes")
	public static CriteriaDefinition convert(SearchCriterion criterion) {
		if (logger.isDebugEnabled()) {
			logger.debug("criterion: " + criterion);
		}

		if ((criterion instanceof SingleFieldValueRestriction)) {
			logger.debug("instanceof SingleFieldValueRestriction");
			return convert_((SingleFieldValueRestriction) criterion);
		}

		if ((criterion instanceof StringRestriction)) {
			logger.debug("instanceof StringRestriction");
			return convert_((StringRestriction) criterion);
		}

		if ((criterion instanceof FieldRangeRestriction)) {
			logger.debug("instanceof FieldRangeRestriction");
			return convert_((FieldRangeRestriction) criterion);
		}

		if ((criterion instanceof InterFieldsRestriction)) {
			logger.debug("instanceof InterFieldsRestriction");
			return convert_((InterFieldsRestriction) criterion);
		}

		if ((criterion instanceof FieldInCollectionRestriction)) {
			logger.debug("instanceof FieldInCollectionRestriction");
			return convert_((FieldInCollectionRestriction) criterion);
		}

		throw new NotImplementedException("Unknown criterion type.");
	}

}
