package com.haoyukeji.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketInStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketInStockExample() {
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

        public Criteria andInStockNameIsNull() {
            addCriterion("in_stock_name is null");
            return (Criteria) this;
        }

        public Criteria andInStockNameIsNotNull() {
            addCriterion("in_stock_name is not null");
            return (Criteria) this;
        }

        public Criteria andInStockNameEqualTo(String value) {
            addCriterion("in_stock_name =", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameNotEqualTo(String value) {
            addCriterion("in_stock_name <>", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameGreaterThan(String value) {
            addCriterion("in_stock_name >", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameGreaterThanOrEqualTo(String value) {
            addCriterion("in_stock_name >=", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameLessThan(String value) {
            addCriterion("in_stock_name <", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameLessThanOrEqualTo(String value) {
            addCriterion("in_stock_name <=", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameLike(String value) {
            addCriterion("in_stock_name like", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameNotLike(String value) {
            addCriterion("in_stock_name not like", value, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameIn(List<String> values) {
            addCriterion("in_stock_name in", values, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameNotIn(List<String> values) {
            addCriterion("in_stock_name not in", values, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameBetween(String value1, String value2) {
            addCriterion("in_stock_name between", value1, value2, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNameNotBetween(String value1, String value2) {
            addCriterion("in_stock_name not between", value1, value2, "inStockName");
            return (Criteria) this;
        }

        public Criteria andInStockNumIsNull() {
            addCriterion("in_stock_num is null");
            return (Criteria) this;
        }

        public Criteria andInStockNumIsNotNull() {
            addCriterion("in_stock_num is not null");
            return (Criteria) this;
        }

        public Criteria andInStockNumEqualTo(String value) {
            addCriterion("in_stock_num =", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumNotEqualTo(String value) {
            addCriterion("in_stock_num <>", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumGreaterThan(String value) {
            addCriterion("in_stock_num >", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumGreaterThanOrEqualTo(String value) {
            addCriterion("in_stock_num >=", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumLessThan(String value) {
            addCriterion("in_stock_num <", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumLessThanOrEqualTo(String value) {
            addCriterion("in_stock_num <=", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumLike(String value) {
            addCriterion("in_stock_num like", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumNotLike(String value) {
            addCriterion("in_stock_num not like", value, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumIn(List<String> values) {
            addCriterion("in_stock_num in", values, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumNotIn(List<String> values) {
            addCriterion("in_stock_num not in", values, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumBetween(String value1, String value2) {
            addCriterion("in_stock_num between", value1, value2, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockNumNotBetween(String value1, String value2) {
            addCriterion("in_stock_num not between", value1, value2, "inStockNum");
            return (Criteria) this;
        }

        public Criteria andInStockSumIsNull() {
            addCriterion("in_stock_sum is null");
            return (Criteria) this;
        }

        public Criteria andInStockSumIsNotNull() {
            addCriterion("in_stock_sum is not null");
            return (Criteria) this;
        }

        public Criteria andInStockSumEqualTo(String value) {
            addCriterion("in_stock_sum =", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumNotEqualTo(String value) {
            addCriterion("in_stock_sum <>", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumGreaterThan(String value) {
            addCriterion("in_stock_sum >", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumGreaterThanOrEqualTo(String value) {
            addCriterion("in_stock_sum >=", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumLessThan(String value) {
            addCriterion("in_stock_sum <", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumLessThanOrEqualTo(String value) {
            addCriterion("in_stock_sum <=", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumLike(String value) {
            addCriterion("in_stock_sum like", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumNotLike(String value) {
            addCriterion("in_stock_sum not like", value, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumIn(List<String> values) {
            addCriterion("in_stock_sum in", values, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumNotIn(List<String> values) {
            addCriterion("in_stock_sum not in", values, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumBetween(String value1, String value2) {
            addCriterion("in_stock_sum between", value1, value2, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockSumNotBetween(String value1, String value2) {
            addCriterion("in_stock_sum not between", value1, value2, "inStockSum");
            return (Criteria) this;
        }

        public Criteria andInStockStartIsNull() {
            addCriterion("in_stock_start is null");
            return (Criteria) this;
        }

        public Criteria andInStockStartIsNotNull() {
            addCriterion("in_stock_start is not null");
            return (Criteria) this;
        }

        public Criteria andInStockStartEqualTo(String value) {
            addCriterion("in_stock_start =", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartNotEqualTo(String value) {
            addCriterion("in_stock_start <>", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartGreaterThan(String value) {
            addCriterion("in_stock_start >", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartGreaterThanOrEqualTo(String value) {
            addCriterion("in_stock_start >=", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartLessThan(String value) {
            addCriterion("in_stock_start <", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartLessThanOrEqualTo(String value) {
            addCriterion("in_stock_start <=", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartLike(String value) {
            addCriterion("in_stock_start like", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartNotLike(String value) {
            addCriterion("in_stock_start not like", value, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartIn(List<String> values) {
            addCriterion("in_stock_start in", values, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartNotIn(List<String> values) {
            addCriterion("in_stock_start not in", values, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartBetween(String value1, String value2) {
            addCriterion("in_stock_start between", value1, value2, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockStartNotBetween(String value1, String value2) {
            addCriterion("in_stock_start not between", value1, value2, "inStockStart");
            return (Criteria) this;
        }

        public Criteria andInStockEndIsNull() {
            addCriterion("in_stock_end is null");
            return (Criteria) this;
        }

        public Criteria andInStockEndIsNotNull() {
            addCriterion("in_stock_end is not null");
            return (Criteria) this;
        }

        public Criteria andInStockEndEqualTo(String value) {
            addCriterion("in_stock_end =", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndNotEqualTo(String value) {
            addCriterion("in_stock_end <>", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndGreaterThan(String value) {
            addCriterion("in_stock_end >", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndGreaterThanOrEqualTo(String value) {
            addCriterion("in_stock_end >=", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndLessThan(String value) {
            addCriterion("in_stock_end <", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndLessThanOrEqualTo(String value) {
            addCriterion("in_stock_end <=", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndLike(String value) {
            addCriterion("in_stock_end like", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndNotLike(String value) {
            addCriterion("in_stock_end not like", value, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndIn(List<String> values) {
            addCriterion("in_stock_end in", values, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndNotIn(List<String> values) {
            addCriterion("in_stock_end not in", values, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndBetween(String value1, String value2) {
            addCriterion("in_stock_end between", value1, value2, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andInStockEndNotBetween(String value1, String value2) {
            addCriterion("in_stock_end not between", value1, value2, "inStockEnd");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateIsNull() {
            addCriterion("ticket_in_stock_state is null");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateIsNotNull() {
            addCriterion("ticket_in_stock_state is not null");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateEqualTo(String value) {
            addCriterion("ticket_in_stock_state =", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateNotEqualTo(String value) {
            addCriterion("ticket_in_stock_state <>", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateGreaterThan(String value) {
            addCriterion("ticket_in_stock_state >", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_in_stock_state >=", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateLessThan(String value) {
            addCriterion("ticket_in_stock_state <", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateLessThanOrEqualTo(String value) {
            addCriterion("ticket_in_stock_state <=", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateLike(String value) {
            addCriterion("ticket_in_stock_state like", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateNotLike(String value) {
            addCriterion("ticket_in_stock_state not like", value, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateIn(List<String> values) {
            addCriterion("ticket_in_stock_state in", values, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateNotIn(List<String> values) {
            addCriterion("ticket_in_stock_state not in", values, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateBetween(String value1, String value2) {
            addCriterion("ticket_in_stock_state between", value1, value2, "ticketInStockState");
            return (Criteria) this;
        }

        public Criteria andTicketInStockStateNotBetween(String value1, String value2) {
            addCriterion("ticket_in_stock_state not between", value1, value2, "ticketInStockState");
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