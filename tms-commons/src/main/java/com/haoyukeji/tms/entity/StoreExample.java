package com.haoyukeji.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreMobileIsNull() {
            addCriterion("store_mobile is null");
            return (Criteria) this;
        }

        public Criteria andStoreMobileIsNotNull() {
            addCriterion("store_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andStoreMobileEqualTo(String value) {
            addCriterion("store_mobile =", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileNotEqualTo(String value) {
            addCriterion("store_mobile <>", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileGreaterThan(String value) {
            addCriterion("store_mobile >", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileGreaterThanOrEqualTo(String value) {
            addCriterion("store_mobile >=", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileLessThan(String value) {
            addCriterion("store_mobile <", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileLessThanOrEqualTo(String value) {
            addCriterion("store_mobile <=", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileLike(String value) {
            addCriterion("store_mobile like", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileNotLike(String value) {
            addCriterion("store_mobile not like", value, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileIn(List<String> values) {
            addCriterion("store_mobile in", values, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileNotIn(List<String> values) {
            addCriterion("store_mobile not in", values, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileBetween(String value1, String value2) {
            addCriterion("store_mobile between", value1, value2, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreMobileNotBetween(String value1, String value2) {
            addCriterion("store_mobile not between", value1, value2, "storeMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAdminIsNull() {
            addCriterion("store_admin is null");
            return (Criteria) this;
        }

        public Criteria andStoreAdminIsNotNull() {
            addCriterion("store_admin is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAdminEqualTo(String value) {
            addCriterion("store_admin =", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminNotEqualTo(String value) {
            addCriterion("store_admin <>", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminGreaterThan(String value) {
            addCriterion("store_admin >", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminGreaterThanOrEqualTo(String value) {
            addCriterion("store_admin >=", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminLessThan(String value) {
            addCriterion("store_admin <", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminLessThanOrEqualTo(String value) {
            addCriterion("store_admin <=", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminLike(String value) {
            addCriterion("store_admin like", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminNotLike(String value) {
            addCriterion("store_admin not like", value, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminIn(List<String> values) {
            addCriterion("store_admin in", values, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminNotIn(List<String> values) {
            addCriterion("store_admin not in", values, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminBetween(String value1, String value2) {
            addCriterion("store_admin between", value1, value2, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAdminNotBetween(String value1, String value2) {
            addCriterion("store_admin not between", value1, value2, "storeAdmin");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreProofIsNull() {
            addCriterion("store_proof is null");
            return (Criteria) this;
        }

        public Criteria andStoreProofIsNotNull() {
            addCriterion("store_proof is not null");
            return (Criteria) this;
        }

        public Criteria andStoreProofEqualTo(String value) {
            addCriterion("store_proof =", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofNotEqualTo(String value) {
            addCriterion("store_proof <>", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofGreaterThan(String value) {
            addCriterion("store_proof >", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofGreaterThanOrEqualTo(String value) {
            addCriterion("store_proof >=", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofLessThan(String value) {
            addCriterion("store_proof <", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofLessThanOrEqualTo(String value) {
            addCriterion("store_proof <=", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofLike(String value) {
            addCriterion("store_proof like", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofNotLike(String value) {
            addCriterion("store_proof not like", value, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofIn(List<String> values) {
            addCriterion("store_proof in", values, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofNotIn(List<String> values) {
            addCriterion("store_proof not in", values, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofBetween(String value1, String value2) {
            addCriterion("store_proof between", value1, value2, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreProofNotBetween(String value1, String value2) {
            addCriterion("store_proof not between", value1, value2, "storeProof");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontIsNull() {
            addCriterion("store_idcard_front is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontIsNotNull() {
            addCriterion("store_idcard_front is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontEqualTo(String value) {
            addCriterion("store_idcard_front =", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontNotEqualTo(String value) {
            addCriterion("store_idcard_front <>", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontGreaterThan(String value) {
            addCriterion("store_idcard_front >", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontGreaterThanOrEqualTo(String value) {
            addCriterion("store_idcard_front >=", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontLessThan(String value) {
            addCriterion("store_idcard_front <", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontLessThanOrEqualTo(String value) {
            addCriterion("store_idcard_front <=", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontLike(String value) {
            addCriterion("store_idcard_front like", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontNotLike(String value) {
            addCriterion("store_idcard_front not like", value, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontIn(List<String> values) {
            addCriterion("store_idcard_front in", values, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontNotIn(List<String> values) {
            addCriterion("store_idcard_front not in", values, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontBetween(String value1, String value2) {
            addCriterion("store_idcard_front between", value1, value2, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardFrontNotBetween(String value1, String value2) {
            addCriterion("store_idcard_front not between", value1, value2, "storeIdcardFront");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeIsNull() {
            addCriterion("store_idcard_negative is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeIsNotNull() {
            addCriterion("store_idcard_negative is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeEqualTo(String value) {
            addCriterion("store_idcard_negative =", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeNotEqualTo(String value) {
            addCriterion("store_idcard_negative <>", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeGreaterThan(String value) {
            addCriterion("store_idcard_negative >", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeGreaterThanOrEqualTo(String value) {
            addCriterion("store_idcard_negative >=", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeLessThan(String value) {
            addCriterion("store_idcard_negative <", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeLessThanOrEqualTo(String value) {
            addCriterion("store_idcard_negative <=", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeLike(String value) {
            addCriterion("store_idcard_negative like", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeNotLike(String value) {
            addCriterion("store_idcard_negative not like", value, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeIn(List<String> values) {
            addCriterion("store_idcard_negative in", values, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeNotIn(List<String> values) {
            addCriterion("store_idcard_negative not in", values, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeBetween(String value1, String value2) {
            addCriterion("store_idcard_negative between", value1, value2, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreIdcardNegativeNotBetween(String value1, String value2) {
            addCriterion("store_idcard_negative not between", value1, value2, "storeIdcardNegative");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIsNull() {
            addCriterion("store_longitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIsNotNull() {
            addCriterion("store_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeEqualTo(String value) {
            addCriterion("store_longitude =", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotEqualTo(String value) {
            addCriterion("store_longitude <>", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeGreaterThan(String value) {
            addCriterion("store_longitude >", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("store_longitude >=", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLessThan(String value) {
            addCriterion("store_longitude <", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLessThanOrEqualTo(String value) {
            addCriterion("store_longitude <=", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLike(String value) {
            addCriterion("store_longitude like", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotLike(String value) {
            addCriterion("store_longitude not like", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIn(List<String> values) {
            addCriterion("store_longitude in", values, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotIn(List<String> values) {
            addCriterion("store_longitude not in", values, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeBetween(String value1, String value2) {
            addCriterion("store_longitude between", value1, value2, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotBetween(String value1, String value2) {
            addCriterion("store_longitude not between", value1, value2, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIsNull() {
            addCriterion("store_latitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIsNotNull() {
            addCriterion("store_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeEqualTo(String value) {
            addCriterion("store_latitude =", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotEqualTo(String value) {
            addCriterion("store_latitude <>", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeGreaterThan(String value) {
            addCriterion("store_latitude >", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("store_latitude >=", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLessThan(String value) {
            addCriterion("store_latitude <", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLessThanOrEqualTo(String value) {
            addCriterion("store_latitude <=", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLike(String value) {
            addCriterion("store_latitude like", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotLike(String value) {
            addCriterion("store_latitude not like", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIn(List<String> values) {
            addCriterion("store_latitude in", values, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotIn(List<String> values) {
            addCriterion("store_latitude not in", values, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeBetween(String value1, String value2) {
            addCriterion("store_latitude between", value1, value2, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotBetween(String value1, String value2) {
            addCriterion("store_latitude not between", value1, value2, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreStateIsNull() {
            addCriterion("store_state is null");
            return (Criteria) this;
        }

        public Criteria andStoreStateIsNotNull() {
            addCriterion("store_state is not null");
            return (Criteria) this;
        }

        public Criteria andStoreStateEqualTo(String value) {
            addCriterion("store_state =", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateNotEqualTo(String value) {
            addCriterion("store_state <>", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateGreaterThan(String value) {
            addCriterion("store_state >", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateGreaterThanOrEqualTo(String value) {
            addCriterion("store_state >=", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateLessThan(String value) {
            addCriterion("store_state <", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateLessThanOrEqualTo(String value) {
            addCriterion("store_state <=", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateLike(String value) {
            addCriterion("store_state like", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateNotLike(String value) {
            addCriterion("store_state not like", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateIn(List<String> values) {
            addCriterion("store_state in", values, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateNotIn(List<String> values) {
            addCriterion("store_state not in", values, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateBetween(String value1, String value2) {
            addCriterion("store_state between", value1, value2, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateNotBetween(String value1, String value2) {
            addCriterion("store_state not between", value1, value2, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeIsNull() {
            addCriterion("store_create_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeIsNotNull() {
            addCriterion("store_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeEqualTo(Date value) {
            addCriterion("store_create_time =", value, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeNotEqualTo(Date value) {
            addCriterion("store_create_time <>", value, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeGreaterThan(Date value) {
            addCriterion("store_create_time >", value, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_create_time >=", value, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeLessThan(Date value) {
            addCriterion("store_create_time <", value, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_create_time <=", value, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeIn(List<Date> values) {
            addCriterion("store_create_time in", values, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeNotIn(List<Date> values) {
            addCriterion("store_create_time not in", values, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeBetween(Date value1, Date value2) {
            addCriterion("store_create_time between", value1, value2, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_create_time not between", value1, value2, "storeCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdIsNull() {
            addCriterion("store_account_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdIsNotNull() {
            addCriterion("store_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdEqualTo(Integer value) {
            addCriterion("store_account_id =", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdNotEqualTo(Integer value) {
            addCriterion("store_account_id <>", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdGreaterThan(Integer value) {
            addCriterion("store_account_id >", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_account_id >=", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdLessThan(Integer value) {
            addCriterion("store_account_id <", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_account_id <=", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdIn(List<Integer> values) {
            addCriterion("store_account_id in", values, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdNotIn(List<Integer> values) {
            addCriterion("store_account_id not in", values, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("store_account_id between", value1, value2, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_account_id not between", value1, value2, "storeAccountId");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}