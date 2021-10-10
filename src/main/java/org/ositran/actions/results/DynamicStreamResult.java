/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.actions.results;

import org.apache.struts2.dispatcher.StreamResult;

import com.opensymphony.xwork2.ActionInvocation;

public class DynamicStreamResult extends StreamResult{
	/**
	 * 
	 */
	private static final long serialVersionUID=-8887245768812456360L;

	@Override
	protected void doExecute(String finalLocation,ActionInvocation invocation) throws Exception{
		// get name of downloaded file
		String downloadedFileName=(String) invocation.getStack().findValue(conditionalParse("name",invocation));
		contentDisposition="attachment;filename=\""+downloadedFileName+"\"";
		// get file size
		contentLength=""+invocation.getStack().findValue(conditionalParse("size",invocation));
		// get type of file
		contentType=""+invocation.getStack().findValue(conditionalParse("description",invocation));
		/*
		 * Executes the result given a final location (jsp page, action, etc)
		 * and the action invocation (the state in which the action was
		 * executed).
		 */
		super.doExecute(finalLocation,invocation);
	}
}
