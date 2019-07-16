ALTER TABLE pond_ms.REVIEWS
    ALTER confirmed TYPE bigint
    USING
        CASE
            WHEN confirmed THEN 1
            ELSE 0
        END;
