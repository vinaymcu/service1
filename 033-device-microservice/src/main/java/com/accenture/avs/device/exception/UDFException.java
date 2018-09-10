/***************************************************************************
 * Copyright (C) Accenture
 *
 * The reproduction, transmission or use of this document or its contents is not permitted without
 * prior express written consent of Accenture. Offenders will be liable for damages. All rights,
 * including but not limited to rights created by patent grant or registration of a utility model or
 * design, are reserved.
 *
 * Accenture reserves the right to modify technical specifications and features.
 *
 * Technical specifications and features are binding only insofar as they are specifically and
 * expressly agreed upon in a written contract.
 *
 **************************************************************************/

package com.accenture.avs.device.exception;

//import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.IErrorCode;

/**
 * Created by IntelliJ IDEA. User: ajitpratap.singh Date: May 25, 2005 Time: 9:40:37 AM To change
 * this template use Options | File Templates.
 * 
 * @author $author$
 * @version $Date$
 */
public class UDFException extends Exception implements IErrorCode{
    
    /**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
//
//	/** DOCUMENT ME! */
//    private Throwable cause;
//    
//    /** The error code. */
//    private IErrorCode errorCode;
//    
//    /**
//     * Creates a new UDFException object.
//     */
//    public UDFException() {
//        super();
//    }
//    
//    /**
//     * Creates a new UDFException object.
//     * 
//     * @param msg DOCUMENT ME!
//     */
//    public UDFException(String msg) {
//        super(msg);
//    }
//    
//    /**
//     * Creates a new UDFException object.
//     * 
//     * @param cause DOCUMENT ME!
//     */
//    public UDFException(Throwable cause) {
//        this.cause = cause;
//    }
//    
//    /**
//     * Creates a new UDFException object.
//     * 
//     * @param msg DOCUMENT ME!
//     * @param cause DOCUMENT ME!
//     */
//    public UDFException(String msg, Throwable cause) {
//        super(msg);
//        this.cause = cause;
//    }
//    
//    /**
//     * 
//     * @param errorCode
//     */
//    public UDFException(ErrorCode errorCode) {
//    	this.errorCode = errorCode;
//	}
//
//    /**
//     * 
//     * @param errorCode
//     * @param msg
//     */
//    public UDFException(ErrorCode errorCode, String msg) {
//        super(msg);
//        this.errorCode = errorCode;
//    }
//    
//	/**
//     * Returns $param.name$
//     * 
//     * @return
//     */
//    public Throwable getCause() {
//        return cause;
//    }
//    
//    /**
//     * DOCUMENT ME!
//     */
//    @Override
//    public void printStackTrace() {
//        super.printStackTrace();
//        
//        if (cause != null) {
//            cause.printStackTrace();
//        }
//    }
//    
//    /**
//     * DOCUMENT ME!
//     * 
//     * @param ps
//     */
//    @Override
//    public void printStackTrace(java.io.PrintStream ps) {
//        super.printStackTrace(ps);
//        
//        if (cause != null) {
//            cause.printStackTrace(ps);
//        }
//    }
//    
//    /**
//     * DOCUMENT ME!
//     * 
//     * @param pw
//     */
//    @Override
//    public void printStackTrace(java.io.PrintWriter pw) {
//        super.printStackTrace(pw);
//        
//        if (cause != null) {
//            cause.printStackTrace(pw);
//        }
//    }
//
//	/**
//	 * @return the errorCode
//	 */
//	public IErrorCode getErrorCode() {
//		return errorCode;
//	}
//
	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
} // end class UDFException
