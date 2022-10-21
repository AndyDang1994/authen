/**
 * 
 *//*
	 * package com.hacorp.authen.configuration;
	 * 
	 * import java.io.UnsupportedEncodingException; import java.net.URLDecoder;
	 * import java.net.URLEncoder; import java.util.Date; import java.util.Iterator;
	 * import java.util.Map;
	 * 
	 * import javax.servlet.http.HttpServletRequest; import
	 * javax.servlet.http.HttpServletResponse;
	 * 
	 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
	 * org.springframework.beans.factory.annotation.Autowired; import
	 * org.springframework.core.env.Environment; import
	 * org.springframework.http.HttpMethod; import
	 * org.springframework.http.HttpStatus; import
	 * org.springframework.security.core.Authentication; import
	 * org.springframework.security.core.context.SecurityContextHolder; import
	 * org.springframework.stereotype.Component; import
	 * org.springframework.web.servlet.HandlerInterceptor; import
	 * org.springframework.web.servlet.ModelAndView;
	 * 
	 * import com.fasterxml.jackson.databind.JsonNode; import
	 * com.fasterxml.jackson.databind.ObjectMapper; import
	 * com.hacorp.authen.core.constant.APIConstant;
	 * 
	 * @Component public class OMSInterceptor implements HandlerInterceptor {
	 * 
	 * @Autowired public Environment env;
	 * 
	 * protected final Logger logger = LoggerFactory.getLogger(getClass());
	 * 
	 * @Override public void afterCompletion(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, Exception ex) throws Exception
	 * { if(request.getAttribute(APIConstant.HTTP_REQUEST_BODY_STR) != null &&
	 * HttpStatus.OK.value() != response.getStatus()){ //logger.info("Body : " +
	 * request.getAttribute(APIConstant.HTTP_REQUEST_BODY_STR));
	 * saveTrackingLogRequestToDB(request, response.getStatus()); }
	 * 
	 * logger.info("***** After completion handle *****"); }
	 * 
	 * @Override public void postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception { int statusCode = response.getStatus();
	 * saveTrackingLogRequestToDB(request, statusCode);
	 * logger.info("***** Post completion handle *****"); }
	 * 
	 * @Override public boolean preHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler) throws Exception {
	 * 
	 * logger.info("***** Begin Pre Interceptor *****");
	 * logger.info("======= Begin Transaction ======="); logger.info(" ***** URL : "
	 * + request.getRequestURI() + " ***** "); logger.info(" ***** Method : " +
	 * request.getMethod() + " ***** "); logger.info(" ***** At : " + new Date());
	 * long startTime = System.currentTimeMillis(); String userName = "";
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * if( auth.getName().equals(("anonymousUser"))) { userName =
	 * APIConstant.ANONYMOUS_USER; }else { CustomUserDetailsModel userDetails =
	 * (CustomUserDetailsModel)auth.getPrincipal(); userName =
	 * userDetails.getUsername(); } logger.info(" ***** userName : " + userName +
	 * " ***** "); request.setAttribute(APIConstant.EXECUTION_TIME_KEY, startTime);
	 * request.setAttribute(APIConstant.USERNAME_KEY, userName);
	 * 
	 * writeLogHttpSerlvetRequest(request);
	 * 
	 * return true; }
	 * 
	 * private void saveTrackingLogRequestToDB(HttpServletRequest request, int
	 * statusCode){ long starttime = (long)
	 * request.getAttribute(APIConstant.EXECUTION_TIME_KEY); long endTime =
	 * System.currentTimeMillis(); long spentTime = (endTime - starttime);
	 * if(request.getMethod().equals(HttpMethod.POST.toString()) ||
	 * request.getMethod().equals(HttpMethod.PATCH.toString())){
	 * if(request.getAttribute(APIConstant.HTTP_REQUEST_BODY_STR) != null){
	 * ObjectMapper objectMapper = new ObjectMapper(); String json =
	 * request.getAttribute(APIConstant.HTTP_REQUEST_BODY_STR).toString(); try{
	 * JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
	 * logger.info("Body : " + jsonNode.toString()); }catch(Exception e){
	 * logger.info("Body : " + json); } } } logger.info("Time Execution : " +
	 * spentTime); logger.info("At : " + new Date());
	 * logger.info("======= End Transaction ======="); }
	 * 
	 * public void writeLogHttpSerlvetRequest(HttpServletRequest httpServletRequest)
	 * throws UnsupportedEncodingException { Map<?, ?> params =
	 * httpServletRequest.getParameterMap(); Iterator<?> i =
	 * params.keySet().iterator(); while (i.hasNext()) { String key = (String)
	 * i.next(); if(params.containsKey(key)){ String[] strs = (String[])
	 * params.get(key); if(strs != null && strs.length > 0){ for(String str : strs){
	 * logger.info("Key : " + key); logger.info("Value : " + str);
	 * logger.info("Value Decode UTF-8 : " + URLDecoder.decode(str,
	 * APIConstant.UTF_8_CHARSET_TYPE)); logger.info("Value Encode UTF-8 : " +
	 * URLEncoder.encode(str, APIConstant.UTF_8_CHARSET_TYPE)); } } }
	 * 
	 * } } }
	 */