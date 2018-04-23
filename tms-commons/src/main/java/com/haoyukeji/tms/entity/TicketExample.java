package com.haoyukeji.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNull() {
            addCriterion("ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNotNull() {
            addCriterion("ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNumEqualTo(String value) {
            addCriterion("ticket_num =", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotEqualTo(String value) {
            addCriterion("ticket_num <>", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThan(String value) {
            addCriterion("ticket_num >", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_num >=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThan(String value) {
            addCriterion("ticket_num <", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThanOrEqualTo(String value) {
            addCriterion("ticket_num <=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLike(String value) {
            addCriterion("ticket_num like", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotLike(String value) {
            addCriterion("ticket_num not like", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumIn(List<String> values) {
            addCriterion("ticket_num in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotIn(List<String> values) {
            addCriterion("ticket_num not in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumBetween(String value1, String value2) {
            addCriterion("ticket_num between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotBetween(String value1, String value2) {
            addCriterion("ticket_num not between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketSumIsNull() {
            addCriterion("ticket_sum is null");
            return (Criteria) this;
        }

        public Criteria andTicketSumIsNotNull() {
            addCriterion("ticket_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTicketSumEqualTo(String value) {
            addCriterion("ticket_sum =", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumNotEqualTo(String value) {
            addCriterion("ticket_sum <>", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumGreaterThan(String value) {
            addCriterion("ticket_sum >", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_sum >=", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumLessThan(String value) {
            addCriterion("ticket_sum <", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumLessThanOrEqualTo(String value) {
            addCriterion("ticket_sum <=", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumLike(String value) {
            addCriterion("ticket_sum like", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumNotLike(String value) {
            addCriterion("ticket_sum not like", value, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumIn(List<String> values) {
            addCriterion("ticket_sum in", values, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumNotIn(List<String> values) {
            addCriterion("ticket_sum not in", values, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumBetween(String value1, String value2) {
            addCriterion("ticket_sum between", value1, value2, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketSumNotBetween(String value1, String value2) {
            addCriterion("ticket_sum not between", value1, value2, "ticketSum");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeIsNull() {
            addCriterion("ticket_in_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeIsNotNull() {
            addCriterion("ticket_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeEqualTo(Date value) {
            addCriterion("ticket_in_time =", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeNotEqualTo(Date value) {
            addCriterion("ticket_in_time <>", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeGreaterThan(Date value) {
            addCriterion("ticket_in_time >", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_in_time >=", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeLessThan(Date value) {
            addCriterion("ticket_in_time <", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_in_time <=", value, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeIn(List<Date> values) {
            addCriterion("ticket_in_time in", values, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeNotIn(List<Date> values) {
            addCriterion("ticket_in_time not in", values, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_in_time between", value1, value2, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketInTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_in_time not between", value1, value2, "ticketInTime");
            return (Criteria) this;
        }

        public Criteria andTicketStateIsNull() {
            addCriterion("ticket_state is null");
            return (Criteria) this;
        }

        public Criteria andTicketStateIsNotNull() {
            addCriterion("ticket_state is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStateEqualTo(String value) {
            addCriterion("ticket_state =", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotEqualTo(String value) {
            addCriterion("ticket_state <>", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateGreaterThan(String value) {
            addCriterion("ticket_state >", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_state >=", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateLessThan(String value) {
            addCriterion("ticket_state <", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateLessThanOrEqualTo(String value) {
            addCriterion("ticket_state <=", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateLike(String value) {
            addCriterion("ticket_state like", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotLike(String value) {
            addCriterion("ticket_state not like", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateIn(List<String> values) {
            addCriterion("ticket_state in", values, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotIn(List<String> values) {
            addCriterion("ticket_state not in", values, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateBetween(String value1, String value2) {
            addCriterion("ticket_state between", value1, value2, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotBetween(String value1, String value2) {
            addCriterion("ticket_state not between", value1, value2, "ticketState");
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

        public Criteria andTicketOnTimeIsNull() {
            addCriterion("ticket_on_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeIsNotNull() {
            addCriterion("ticket_on_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeEqualTo(Date value) {
            addCriterion("ticket_on_time =", value, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeNotEqualTo(Date value) {
            addCriterion("ticket_on_time <>", value, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeGreaterThan(Date value) {
            addCriterion("ticket_on_time >", value, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_on_time >=", value, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeLessThan(Date value) {
            addCriterion("ticket_on_time <", value, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_on_time <=", value, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeIn(List<Date> values) {
            addCriterion("ticket_on_time in", values, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeNotIn(List<Date> values) {
            addCriterion("ticket_on_time not in", values, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_on_time between", value1, value2, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketOnTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_on_time not between", value1, value2, "ticketOnTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeIsNull() {
            addCriterion("ticket_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeIsNotNull() {
            addCriterion("ticket_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeEqualTo(Date value) {
            addCriterion("ticket_start_time =", value, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeNotEqualTo(Date value) {
            addCriterion("ticket_start_time <>", value, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeGreaterThan(Date value) {
            addCriterion("ticket_start_time >", value, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_start_time >=", value, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeLessThan(Date value) {
            addCriterion("ticket_start_time <", value, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_start_time <=", value, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeIn(List<Date> values) {
            addCriterion("ticket_start_time in", values, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeNotIn(List<Date> values) {
            addCriterion("ticket_start_time not in", values, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_start_time between", value1, value2, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_start_time not between", value1, value2, "ticketStartTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeIsNull() {
            addCriterion("ticket_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeIsNotNull() {
            addCriterion("ticket_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeEqualTo(Date value) {
            addCriterion("ticket_end_time =", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeNotEqualTo(Date value) {
            addCriterion("ticket_end_time <>", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeGreaterThan(Date value) {
            addCriterion("ticket_end_time >", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_end_time >=", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeLessThan(Date value) {
            addCriterion("ticket_end_time <", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_end_time <=", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeIn(List<Date> values) {
            addCriterion("ticket_end_time in", values, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeNotIn(List<Date> values) {
            addCriterion("ticket_end_time not in", values, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_end_time between", value1, value2, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_end_time not between", value1, value2, "ticketEndTime");
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

        public Criteria andTicketInStockIdIsNull() {
            addCriterion("ticket_in_stock_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdIsNotNull() {
            addCriterion("ticket_in_stock_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdEqualTo(Integer value) {
            addCriterion("ticket_in_stock_id =", value, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdNotEqualTo(Integer value) {
            addCriterion("ticket_in_stock_id <>", value, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdGreaterThan(Integer value) {
            addCriterion("ticket_in_stock_id >", value, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_in_stock_id >=", value, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdLessThan(Integer value) {
            addCriterion("ticket_in_stock_id <", value, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_in_stock_id <=", value, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdIn(List<Integer> values) {
            addCriterion("ticket_in_stock_id in", values, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdNotIn(List<Integer> values) {
            addCriterion("ticket_in_stock_id not in", values, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdBetween(Integer value1, Integer value2) {
            addCriterion("ticket_in_stock_id between", value1, value2, "ticketInStockId");
            return (Criteria) this;
        }

        public Criteria andTicketInStockIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_in_stock_id not between", value1, value2, "ticketInStockId");
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