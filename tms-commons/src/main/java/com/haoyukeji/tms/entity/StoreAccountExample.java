package com.haoyukeji.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreAccountExample() {
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

        public Criteria andStoreAccountNameIsNull() {
            addCriterion("store_account_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameIsNotNull() {
            addCriterion("store_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameEqualTo(String value) {
            addCriterion("store_account_name =", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotEqualTo(String value) {
            addCriterion("store_account_name <>", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameGreaterThan(String value) {
            addCriterion("store_account_name >", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_account_name >=", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameLessThan(String value) {
            addCriterion("store_account_name <", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameLessThanOrEqualTo(String value) {
            addCriterion("store_account_name <=", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameLike(String value) {
            addCriterion("store_account_name like", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotLike(String value) {
            addCriterion("store_account_name not like", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameIn(List<String> values) {
            addCriterion("store_account_name in", values, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotIn(List<String> values) {
            addCriterion("store_account_name not in", values, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameBetween(String value1, String value2) {
            addCriterion("store_account_name between", value1, value2, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotBetween(String value1, String value2) {
            addCriterion("store_account_name not between", value1, value2, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileIsNull() {
            addCriterion("store_account_mobile is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileIsNotNull() {
            addCriterion("store_account_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileEqualTo(String value) {
            addCriterion("store_account_mobile =", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileNotEqualTo(String value) {
            addCriterion("store_account_mobile <>", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileGreaterThan(String value) {
            addCriterion("store_account_mobile >", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileGreaterThanOrEqualTo(String value) {
            addCriterion("store_account_mobile >=", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileLessThan(String value) {
            addCriterion("store_account_mobile <", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileLessThanOrEqualTo(String value) {
            addCriterion("store_account_mobile <=", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileLike(String value) {
            addCriterion("store_account_mobile like", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileNotLike(String value) {
            addCriterion("store_account_mobile not like", value, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileIn(List<String> values) {
            addCriterion("store_account_mobile in", values, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileNotIn(List<String> values) {
            addCriterion("store_account_mobile not in", values, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileBetween(String value1, String value2) {
            addCriterion("store_account_mobile between", value1, value2, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountMobileNotBetween(String value1, String value2) {
            addCriterion("store_account_mobile not between", value1, value2, "storeAccountMobile");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordIsNull() {
            addCriterion("store_account_password is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordIsNotNull() {
            addCriterion("store_account_password is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordEqualTo(String value) {
            addCriterion("store_account_password =", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordNotEqualTo(String value) {
            addCriterion("store_account_password <>", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordGreaterThan(String value) {
            addCriterion("store_account_password >", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("store_account_password >=", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordLessThan(String value) {
            addCriterion("store_account_password <", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordLessThanOrEqualTo(String value) {
            addCriterion("store_account_password <=", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordLike(String value) {
            addCriterion("store_account_password like", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordNotLike(String value) {
            addCriterion("store_account_password not like", value, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordIn(List<String> values) {
            addCriterion("store_account_password in", values, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordNotIn(List<String> values) {
            addCriterion("store_account_password not in", values, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordBetween(String value1, String value2) {
            addCriterion("store_account_password between", value1, value2, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountPasswordNotBetween(String value1, String value2) {
            addCriterion("store_account_password not between", value1, value2, "storeAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeIsNull() {
            addCriterion("store_account_create_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeIsNotNull() {
            addCriterion("store_account_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeEqualTo(Date value) {
            addCriterion("store_account_create_time =", value, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeNotEqualTo(Date value) {
            addCriterion("store_account_create_time <>", value, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeGreaterThan(Date value) {
            addCriterion("store_account_create_time >", value, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_account_create_time >=", value, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeLessThan(Date value) {
            addCriterion("store_account_create_time <", value, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_account_create_time <=", value, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeIn(List<Date> values) {
            addCriterion("store_account_create_time in", values, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeNotIn(List<Date> values) {
            addCriterion("store_account_create_time not in", values, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeBetween(Date value1, Date value2) {
            addCriterion("store_account_create_time between", value1, value2, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_account_create_time not between", value1, value2, "storeAccountCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeIsNull() {
            addCriterion("store_account_update_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeIsNotNull() {
            addCriterion("store_account_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeEqualTo(Date value) {
            addCriterion("store_account_update_time =", value, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeNotEqualTo(Date value) {
            addCriterion("store_account_update_time <>", value, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeGreaterThan(Date value) {
            addCriterion("store_account_update_time >", value, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_account_update_time >=", value, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeLessThan(Date value) {
            addCriterion("store_account_update_time <", value, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_account_update_time <=", value, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeIn(List<Date> values) {
            addCriterion("store_account_update_time in", values, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeNotIn(List<Date> values) {
            addCriterion("store_account_update_time not in", values, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("store_account_update_time between", value1, value2, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_account_update_time not between", value1, value2, "storeAccountUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateIsNull() {
            addCriterion("store_account_state is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateIsNotNull() {
            addCriterion("store_account_state is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateEqualTo(String value) {
            addCriterion("store_account_state =", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateNotEqualTo(String value) {
            addCriterion("store_account_state <>", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateGreaterThan(String value) {
            addCriterion("store_account_state >", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateGreaterThanOrEqualTo(String value) {
            addCriterion("store_account_state >=", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateLessThan(String value) {
            addCriterion("store_account_state <", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateLessThanOrEqualTo(String value) {
            addCriterion("store_account_state <=", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateLike(String value) {
            addCriterion("store_account_state like", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateNotLike(String value) {
            addCriterion("store_account_state not like", value, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateIn(List<String> values) {
            addCriterion("store_account_state in", values, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateNotIn(List<String> values) {
            addCriterion("store_account_state not in", values, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateBetween(String value1, String value2) {
            addCriterion("store_account_state between", value1, value2, "storeAccountState");
            return (Criteria) this;
        }

        public Criteria andStoreAccountStateNotBetween(String value1, String value2) {
            addCriterion("store_account_state not between", value1, value2, "storeAccountState");
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