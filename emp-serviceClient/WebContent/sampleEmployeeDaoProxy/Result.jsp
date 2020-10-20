<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleEmployeeDaoProxyid" scope="session" class="com.ymail.dao.EmployeeDaoProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleEmployeeDaoProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleEmployeeDaoProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleEmployeeDaoProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.ymail.dao.EmployeeDao getEmployeeDao10mtemp = sampleEmployeeDaoProxyid.getEmployeeDao();
if(getEmployeeDao10mtemp == null){
%>
<%=getEmployeeDao10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">jdbcTemplate:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fetchSize:</TD>
<TD>
<%
if(getEmployeeDao10mtemp != null){
org.springframework.jdbc.core.JdbcTemplate tebece0=getEmployeeDao10mtemp.getJdbcTemplate();
if(tebece0 != null){
%>
<%=tebece0.getFetchSize()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">maxRows:</TD>
<TD>
<%
if(getEmployeeDao10mtemp != null){
org.springframework.jdbc.core.JdbcTemplate tebece0=getEmployeeDao10mtemp.getJdbcTemplate();
if(tebece0 != null){
%>
<%=tebece0.getMaxRows()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">queryTimeout:</TD>
<TD>
<%
if(getEmployeeDao10mtemp != null){
org.springframework.jdbc.core.JdbcTemplate tebece0=getEmployeeDao10mtemp.getJdbcTemplate();
if(tebece0 != null){
%>
<%=tebece0.getQueryTimeout()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">skipUndeclaredResults:</TD>
<TD>
<%
if(getEmployeeDao10mtemp != null){
org.springframework.jdbc.core.JdbcTemplate tebece0=getEmployeeDao10mtemp.getJdbcTemplate();
if(tebece0 != null){
%>
<%=tebece0.isSkipUndeclaredResults()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">ignoreWarnings:</TD>
<TD>
<%
if(getEmployeeDao10mtemp != null){
org.springframework.jdbc.core.JdbcTemplate tebece0=getEmployeeDao10mtemp.getJdbcTemplate();
if(tebece0 != null){
%>
<%=tebece0.isIgnoreWarnings()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">resultsMapCaseInsensitive:</TD>
<TD>
<%
if(getEmployeeDao10mtemp != null){
org.springframework.jdbc.core.JdbcTemplate tebece0=getEmployeeDao10mtemp.getJdbcTemplate();
if(tebece0 != null){
%>
<%=tebece0.isResultsMapCaseInsensitive()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">skipResultsProcessing:</TD>
<TD>
<%
if(getEmployeeDao10mtemp != null){
org.springframework.jdbc.core.JdbcTemplate tebece0=getEmployeeDao10mtemp.getJdbcTemplate();
if(tebece0 != null){
%>
<%=tebece0.isSkipResultsProcessing()
%><%}}%>
</TD>
</TABLE>
<%
}
break;
case 31:
        gotMethod = true;
        java.lang.Object[] getDetails31mtemp = sampleEmployeeDaoProxyid.getDetails();
if(getDetails31mtemp == null){
%>
<%=getDetails31mtemp %>
<%
}else{
        String tempreturnp32 = null;
        if(getDetails31mtemp != null){
        java.util.List listreturnp32= java.util.Arrays.asList(getDetails31mtemp);
        tempreturnp32 = listreturnp32.toString();
        }
        %>
        <%=tempreturnp32%>
        <%
}
break;
case 34:
        gotMethod = true;
        org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate34mtemp = sampleEmployeeDaoProxyid.getJdbcTemplate();
if(getJdbcTemplate34mtemp == null){
%>
<%=getJdbcTemplate34mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fetchSize:</TD>
<TD>
<%
if(getJdbcTemplate34mtemp != null){
%>
<%=getJdbcTemplate34mtemp.getFetchSize()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">maxRows:</TD>
<TD>
<%
if(getJdbcTemplate34mtemp != null){
%>
<%=getJdbcTemplate34mtemp.getMaxRows()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">queryTimeout:</TD>
<TD>
<%
if(getJdbcTemplate34mtemp != null){
%>
<%=getJdbcTemplate34mtemp.getQueryTimeout()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">skipUndeclaredResults:</TD>
<TD>
<%
if(getJdbcTemplate34mtemp != null){
%>
<%=getJdbcTemplate34mtemp.isSkipUndeclaredResults()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ignoreWarnings:</TD>
<TD>
<%
if(getJdbcTemplate34mtemp != null){
%>
<%=getJdbcTemplate34mtemp.isIgnoreWarnings()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">resultsMapCaseInsensitive:</TD>
<TD>
<%
if(getJdbcTemplate34mtemp != null){
%>
<%=getJdbcTemplate34mtemp.isResultsMapCaseInsensitive()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">skipResultsProcessing:</TD>
<TD>
<%
if(getJdbcTemplate34mtemp != null){
%>
<%=getJdbcTemplate34mtemp.isSkipResultsProcessing()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 51:
        gotMethod = true;
        String fetchSize_2id=  request.getParameter("fetchSize56");
        int fetchSize_2idTemp  = Integer.parseInt(fetchSize_2id);
        String maxRows_3id=  request.getParameter("maxRows58");
        int maxRows_3idTemp  = Integer.parseInt(maxRows_3id);
        String queryTimeout_4id=  request.getParameter("queryTimeout60");
        int queryTimeout_4idTemp  = Integer.parseInt(queryTimeout_4id);
        String skipUndeclaredResults_5id=  request.getParameter("skipUndeclaredResults62");
        boolean skipUndeclaredResults_5idTemp  = Boolean.valueOf(skipUndeclaredResults_5id).booleanValue();
        String ignoreWarnings_6id=  request.getParameter("ignoreWarnings64");
        boolean ignoreWarnings_6idTemp  = Boolean.valueOf(ignoreWarnings_6id).booleanValue();
        String resultsMapCaseInsensitive_7id=  request.getParameter("resultsMapCaseInsensitive66");
        boolean resultsMapCaseInsensitive_7idTemp  = Boolean.valueOf(resultsMapCaseInsensitive_7id).booleanValue();
        String skipResultsProcessing_8id=  request.getParameter("skipResultsProcessing68");
        boolean skipResultsProcessing_8idTemp  = Boolean.valueOf(skipResultsProcessing_8id).booleanValue();
        %>
        <jsp:useBean id="org1springframework1jdbc1core1JdbcTemplate_1id" scope="session" class="org.springframework.jdbc.core.JdbcTemplate" />
        <%
        org1springframework1jdbc1core1JdbcTemplate_1id.setFetchSize(fetchSize_2idTemp);
        org1springframework1jdbc1core1JdbcTemplate_1id.setMaxRows(maxRows_3idTemp);
        org1springframework1jdbc1core1JdbcTemplate_1id.setQueryTimeout(queryTimeout_4idTemp);
        org1springframework1jdbc1core1JdbcTemplate_1id.setSkipUndeclaredResults(skipUndeclaredResults_5idTemp);
        org1springframework1jdbc1core1JdbcTemplate_1id.setIgnoreWarnings(ignoreWarnings_6idTemp);
        org1springframework1jdbc1core1JdbcTemplate_1id.setResultsMapCaseInsensitive(resultsMapCaseInsensitive_7idTemp);
        org1springframework1jdbc1core1JdbcTemplate_1id.setSkipResultsProcessing(skipResultsProcessing_8idTemp);
        sampleEmployeeDaoProxyid.setJdbcTemplate(org1springframework1jdbc1core1JdbcTemplate_1id);
break;
case 70:
        gotMethod = true;
        sampleEmployeeDaoProxyid.saveEmployee();
break;
case 73:
        gotMethod = true;
        String phone_10id=  request.getParameter("phone78");
            java.lang.String phone_10idTemp = null;
        if(!phone_10id.equals("")){
         phone_10idTemp  = phone_10id;
        }
        String company_11id=  request.getParameter("company80");
            java.lang.String company_11idTemp = null;
        if(!company_11id.equals("")){
         company_11idTemp  = company_11id;
        }
        String name_12id=  request.getParameter("name82");
            java.lang.String name_12idTemp = null;
        if(!name_12id.equals("")){
         name_12idTemp  = name_12id;
        }
        String salary_13id=  request.getParameter("salary84");
        float salary_13idTemp  = Float.parseFloat(salary_13id);
        String id_14id=  request.getParameter("id86");
        int id_14idTemp  = Integer.parseInt(id_14id);
        %>
        <jsp:useBean id="com1ymail1model1EmployeeDetails_9id" scope="session" class="com.ymail.model.EmployeeDetails" />
        <%
        com1ymail1model1EmployeeDetails_9id.setPhone(phone_10idTemp);
        com1ymail1model1EmployeeDetails_9id.setCompany(company_11idTemp);
        com1ymail1model1EmployeeDetails_9id.setName(name_12idTemp);
        com1ymail1model1EmployeeDetails_9id.setSalary(salary_13idTemp);
        com1ymail1model1EmployeeDetails_9id.setId(id_14idTemp);
        sampleEmployeeDaoProxyid.updateEmployee(com1ymail1model1EmployeeDetails_9id);
break;
case 88:
        gotMethod = true;
        String phone_16id=  request.getParameter("phone93");
            java.lang.String phone_16idTemp = null;
        if(!phone_16id.equals("")){
         phone_16idTemp  = phone_16id;
        }
        String company_17id=  request.getParameter("company95");
            java.lang.String company_17idTemp = null;
        if(!company_17id.equals("")){
         company_17idTemp  = company_17id;
        }
        String name_18id=  request.getParameter("name97");
            java.lang.String name_18idTemp = null;
        if(!name_18id.equals("")){
         name_18idTemp  = name_18id;
        }
        String salary_19id=  request.getParameter("salary99");
        float salary_19idTemp  = Float.parseFloat(salary_19id);
        String id_20id=  request.getParameter("id101");
        int id_20idTemp  = Integer.parseInt(id_20id);
        %>
        <jsp:useBean id="com1ymail1model1EmployeeDetails_15id" scope="session" class="com.ymail.model.EmployeeDetails" />
        <%
        com1ymail1model1EmployeeDetails_15id.setPhone(phone_16idTemp);
        com1ymail1model1EmployeeDetails_15id.setCompany(company_17idTemp);
        com1ymail1model1EmployeeDetails_15id.setName(name_18idTemp);
        com1ymail1model1EmployeeDetails_15id.setSalary(salary_19idTemp);
        com1ymail1model1EmployeeDetails_15id.setId(id_20idTemp);
        sampleEmployeeDaoProxyid.deleteEmployee(com1ymail1model1EmployeeDetails_15id);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>