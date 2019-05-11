package com.cryptomip.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SAtresultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SAtresultExample() {
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

        public Criteria andAlgonameIsNull() {
            addCriterion("algoname is null");
            return (Criteria) this;
        }

        public Criteria andAlgonameIsNotNull() {
            addCriterion("algoname is not null");
            return (Criteria) this;
        }

        public Criteria andAlgonameEqualTo(String value) {
            addCriterion("algoname =", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameNotEqualTo(String value) {
            addCriterion("algoname <>", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameGreaterThan(String value) {
            addCriterion("algoname >", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameGreaterThanOrEqualTo(String value) {
            addCriterion("algoname >=", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameLessThan(String value) {
            addCriterion("algoname <", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameLessThanOrEqualTo(String value) {
            addCriterion("algoname <=", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameLike(String value) {
            addCriterion("algoname like", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameNotLike(String value) {
            addCriterion("algoname not like", value, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameIn(List<String> values) {
            addCriterion("algoname in", values, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameNotIn(List<String> values) {
            addCriterion("algoname not in", values, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameBetween(String value1, String value2) {
            addCriterion("algoname between", value1, value2, "algoname");
            return (Criteria) this;
        }

        public Criteria andAlgonameNotBetween(String value1, String value2) {
            addCriterion("algoname not between", value1, value2, "algoname");
            return (Criteria) this;
        }

        public Criteria andTestidIsNull() {
            addCriterion("testid is null");
            return (Criteria) this;
        }

        public Criteria andTestidIsNotNull() {
            addCriterion("testid is not null");
            return (Criteria) this;
        }

        public Criteria andTestidEqualTo(String value) {
            addCriterion("testid =", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotEqualTo(String value) {
            addCriterion("testid <>", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThan(String value) {
            addCriterion("testid >", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThanOrEqualTo(String value) {
            addCriterion("testid >=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThan(String value) {
            addCriterion("testid <", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThanOrEqualTo(String value) {
            addCriterion("testid <=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLike(String value) {
            addCriterion("testid like", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotLike(String value) {
            addCriterion("testid not like", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidIn(List<String> values) {
            addCriterion("testid in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotIn(List<String> values) {
            addCriterion("testid not in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidBetween(String value1, String value2) {
            addCriterion("testid between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotBetween(String value1, String value2) {
            addCriterion("testid not between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andStimeIsNull() {
            addCriterion("stime is null");
            return (Criteria) this;
        }

        public Criteria andStimeIsNotNull() {
            addCriterion("stime is not null");
            return (Criteria) this;
        }

        public Criteria andStimeEqualTo(Date value) {
            addCriterion("stime =", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotEqualTo(Date value) {
            addCriterion("stime <>", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThan(Date value) {
            addCriterion("stime >", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stime >=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThan(Date value) {
            addCriterion("stime <", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThanOrEqualTo(Date value) {
            addCriterion("stime <=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeIn(List<Date> values) {
            addCriterion("stime in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotIn(List<Date> values) {
            addCriterion("stime not in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeBetween(Date value1, Date value2) {
            addCriterion("stime between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotBetween(Date value1, Date value2) {
            addCriterion("stime not between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNull() {
            addCriterion("etime is null");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNotNull() {
            addCriterion("etime is not null");
            return (Criteria) this;
        }

        public Criteria andEtimeEqualTo(Date value) {
            addCriterion("etime =", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotEqualTo(Date value) {
            addCriterion("etime <>", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThan(Date value) {
            addCriterion("etime >", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etime >=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThan(Date value) {
            addCriterion("etime <", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThanOrEqualTo(Date value) {
            addCriterion("etime <=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeIn(List<Date> values) {
            addCriterion("etime in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotIn(List<Date> values) {
            addCriterion("etime not in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeBetween(Date value1, Date value2) {
            addCriterion("etime between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotBetween(Date value1, Date value2) {
            addCriterion("etime not between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andComtimeIsNull() {
            addCriterion("comtime is null");
            return (Criteria) this;
        }

        public Criteria andComtimeIsNotNull() {
            addCriterion("comtime is not null");
            return (Criteria) this;
        }

        public Criteria andComtimeEqualTo(String value) {
            addCriterion("comtime =", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeNotEqualTo(String value) {
            addCriterion("comtime <>", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeGreaterThan(String value) {
            addCriterion("comtime >", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeGreaterThanOrEqualTo(String value) {
            addCriterion("comtime >=", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeLessThan(String value) {
            addCriterion("comtime <", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeLessThanOrEqualTo(String value) {
            addCriterion("comtime <=", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeLike(String value) {
            addCriterion("comtime like", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeNotLike(String value) {
            addCriterion("comtime not like", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeIn(List<String> values) {
            addCriterion("comtime in", values, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeNotIn(List<String> values) {
            addCriterion("comtime not in", values, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeBetween(String value1, String value2) {
            addCriterion("comtime between", value1, value2, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeNotBetween(String value1, String value2) {
            addCriterion("comtime not between", value1, value2, "comtime");
            return (Criteria) this;
        }

        public Criteria andAttacktypeIsNull() {
            addCriterion("attacktype is null");
            return (Criteria) this;
        }

        public Criteria andAttacktypeIsNotNull() {
            addCriterion("attacktype is not null");
            return (Criteria) this;
        }

        public Criteria andAttacktypeEqualTo(String value) {
            addCriterion("attacktype =", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeNotEqualTo(String value) {
            addCriterion("attacktype <>", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeGreaterThan(String value) {
            addCriterion("attacktype >", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeGreaterThanOrEqualTo(String value) {
            addCriterion("attacktype >=", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeLessThan(String value) {
            addCriterion("attacktype <", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeLessThanOrEqualTo(String value) {
            addCriterion("attacktype <=", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeLike(String value) {
            addCriterion("attacktype like", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeNotLike(String value) {
            addCriterion("attacktype not like", value, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeIn(List<String> values) {
            addCriterion("attacktype in", values, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeNotIn(List<String> values) {
            addCriterion("attacktype not in", values, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeBetween(String value1, String value2) {
            addCriterion("attacktype between", value1, value2, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttacktypeNotBetween(String value1, String value2) {
            addCriterion("attacktype not between", value1, value2, "attacktype");
            return (Criteria) this;
        }

        public Criteria andAttackmodeIsNull() {
            addCriterion("attackmode is null");
            return (Criteria) this;
        }

        public Criteria andAttackmodeIsNotNull() {
            addCriterion("attackmode is not null");
            return (Criteria) this;
        }

        public Criteria andAttackmodeEqualTo(String value) {
            addCriterion("attackmode =", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeNotEqualTo(String value) {
            addCriterion("attackmode <>", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeGreaterThan(String value) {
            addCriterion("attackmode >", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeGreaterThanOrEqualTo(String value) {
            addCriterion("attackmode >=", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeLessThan(String value) {
            addCriterion("attackmode <", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeLessThanOrEqualTo(String value) {
            addCriterion("attackmode <=", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeLike(String value) {
            addCriterion("attackmode like", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeNotLike(String value) {
            addCriterion("attackmode not like", value, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeIn(List<String> values) {
            addCriterion("attackmode in", values, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeNotIn(List<String> values) {
            addCriterion("attackmode not in", values, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeBetween(String value1, String value2) {
            addCriterion("attackmode between", value1, value2, "attackmode");
            return (Criteria) this;
        }

        public Criteria andAttackmodeNotBetween(String value1, String value2) {
            addCriterion("attackmode not between", value1, value2, "attackmode");
            return (Criteria) this;
        }

        public Criteria andRoundIsNull() {
            addCriterion("round is null");
            return (Criteria) this;
        }

        public Criteria andRoundIsNotNull() {
            addCriterion("round is not null");
            return (Criteria) this;
        }

        public Criteria andRoundEqualTo(Integer value) {
            addCriterion("round =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(Integer value) {
            addCriterion("round <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(Integer value) {
            addCriterion("round >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("round >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(Integer value) {
            addCriterion("round <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(Integer value) {
            addCriterion("round <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<Integer> values) {
            addCriterion("round in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<Integer> values) {
            addCriterion("round not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(Integer value1, Integer value2) {
            addCriterion("round between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("round not between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andAttackparaIsNull() {
            addCriterion("attackpara is null");
            return (Criteria) this;
        }

        public Criteria andAttackparaIsNotNull() {
            addCriterion("attackpara is not null");
            return (Criteria) this;
        }

        public Criteria andAttackparaEqualTo(String value) {
            addCriterion("attackpara =", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaNotEqualTo(String value) {
            addCriterion("attackpara <>", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaGreaterThan(String value) {
            addCriterion("attackpara >", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaGreaterThanOrEqualTo(String value) {
            addCriterion("attackpara >=", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaLessThan(String value) {
            addCriterion("attackpara <", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaLessThanOrEqualTo(String value) {
            addCriterion("attackpara <=", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaLike(String value) {
            addCriterion("attackpara like", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaNotLike(String value) {
            addCriterion("attackpara not like", value, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaIn(List<String> values) {
            addCriterion("attackpara in", values, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaNotIn(List<String> values) {
            addCriterion("attackpara not in", values, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaBetween(String value1, String value2) {
            addCriterion("attackpara between", value1, value2, "attackpara");
            return (Criteria) this;
        }

        public Criteria andAttackparaNotBetween(String value1, String value2) {
            addCriterion("attackpara not between", value1, value2, "attackpara");
            return (Criteria) this;
        }

        public Criteria andTestresult1IsNull() {
            addCriterion("testresult1 is null");
            return (Criteria) this;
        }

        public Criteria andTestresult1IsNotNull() {
            addCriterion("testresult1 is not null");
            return (Criteria) this;
        }

        public Criteria andTestresult1EqualTo(String value) {
            addCriterion("testresult1 =", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1NotEqualTo(String value) {
            addCriterion("testresult1 <>", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1GreaterThan(String value) {
            addCriterion("testresult1 >", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1GreaterThanOrEqualTo(String value) {
            addCriterion("testresult1 >=", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1LessThan(String value) {
            addCriterion("testresult1 <", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1LessThanOrEqualTo(String value) {
            addCriterion("testresult1 <=", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1Like(String value) {
            addCriterion("testresult1 like", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1NotLike(String value) {
            addCriterion("testresult1 not like", value, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1In(List<String> values) {
            addCriterion("testresult1 in", values, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1NotIn(List<String> values) {
            addCriterion("testresult1 not in", values, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1Between(String value1, String value2) {
            addCriterion("testresult1 between", value1, value2, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult1NotBetween(String value1, String value2) {
            addCriterion("testresult1 not between", value1, value2, "testresult1");
            return (Criteria) this;
        }

        public Criteria andTestresult2IsNull() {
            addCriterion("testresult2 is null");
            return (Criteria) this;
        }

        public Criteria andTestresult2IsNotNull() {
            addCriterion("testresult2 is not null");
            return (Criteria) this;
        }

        public Criteria andTestresult2EqualTo(String value) {
            addCriterion("testresult2 =", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2NotEqualTo(String value) {
            addCriterion("testresult2 <>", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2GreaterThan(String value) {
            addCriterion("testresult2 >", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2GreaterThanOrEqualTo(String value) {
            addCriterion("testresult2 >=", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2LessThan(String value) {
            addCriterion("testresult2 <", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2LessThanOrEqualTo(String value) {
            addCriterion("testresult2 <=", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2Like(String value) {
            addCriterion("testresult2 like", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2NotLike(String value) {
            addCriterion("testresult2 not like", value, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2In(List<String> values) {
            addCriterion("testresult2 in", values, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2NotIn(List<String> values) {
            addCriterion("testresult2 not in", values, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2Between(String value1, String value2) {
            addCriterion("testresult2 between", value1, value2, "testresult2");
            return (Criteria) this;
        }

        public Criteria andTestresult2NotBetween(String value1, String value2) {
            addCriterion("testresult2 not between", value1, value2, "testresult2");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNull() {
            addCriterion("memo1 is null");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNotNull() {
            addCriterion("memo1 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo1EqualTo(String value) {
            addCriterion("memo1 =", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotEqualTo(String value) {
            addCriterion("memo1 <>", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThan(String value) {
            addCriterion("memo1 >", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThanOrEqualTo(String value) {
            addCriterion("memo1 >=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThan(String value) {
            addCriterion("memo1 <", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThanOrEqualTo(String value) {
            addCriterion("memo1 <=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Like(String value) {
            addCriterion("memo1 like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotLike(String value) {
            addCriterion("memo1 not like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1In(List<String> values) {
            addCriterion("memo1 in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotIn(List<String> values) {
            addCriterion("memo1 not in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Between(String value1, String value2) {
            addCriterion("memo1 between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotBetween(String value1, String value2) {
            addCriterion("memo1 not between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNull() {
            addCriterion("memo2 is null");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNotNull() {
            addCriterion("memo2 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo2EqualTo(String value) {
            addCriterion("memo2 =", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotEqualTo(String value) {
            addCriterion("memo2 <>", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThan(String value) {
            addCriterion("memo2 >", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThanOrEqualTo(String value) {
            addCriterion("memo2 >=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThan(String value) {
            addCriterion("memo2 <", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThanOrEqualTo(String value) {
            addCriterion("memo2 <=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Like(String value) {
            addCriterion("memo2 like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotLike(String value) {
            addCriterion("memo2 not like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2In(List<String> values) {
            addCriterion("memo2 in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotIn(List<String> values) {
            addCriterion("memo2 not in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Between(String value1, String value2) {
            addCriterion("memo2 between", value1, value2, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotBetween(String value1, String value2) {
            addCriterion("memo2 not between", value1, value2, "memo2");
            return (Criteria) this;
        }
    }

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