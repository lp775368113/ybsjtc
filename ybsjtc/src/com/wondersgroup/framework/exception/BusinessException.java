package com.wondersgroup.framework.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.exception]
 * @ClassName:    [BusinessException]   
 * @Description:  [自定义业务异常类]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:08:00]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:08:00]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -2589309723938600227L;

	/**@Fields errNo: TODO[异常编码]   */
	protected int errNo;

	/**@Fields sMsg: TODO[用一句话描述这个变量表示什么]   */
	protected String sMsg = "";

	/**@Fields rootCause: TODO[用一句话描述这个变量表示什么]   */
	protected Throwable rootCause;

	/**@Fields ERR_UNKNOWN: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_UNKNOWN = 0;

	/**@Fields ERR_MYEXCEPTION: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_MYEXCEPTION = 1;

	/**@Fields ERR_DATACONVERT: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_DATACONVERT = 2;

	/**@Fields ERR_PARAM_INVALID: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_PARAM_INVALID = 10;

	/**@Fields ERR_OBJ_NULL: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_OBJ_NULL = 20;

	/**@Fields ERR_NUMOP_FAIL: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_NUMOP_FAIL = 30;

	/**@Fields ERR_DBOP_FAIL: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_DBOP_FAIL = 40;

	/**@Fields ERR_CONNECTION_GETFAIL: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_CONNECTION_GETFAIL = 41;

	/**@Fields ERR_FILEOP_FAIL: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_FILEOP_FAIL = 50;

	/**@Fields ERR_FILEOP_OPEN: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_FILEOP_OPEN = 51;

	/**@Fields ERR_FILEOP_CLOSE: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_FILEOP_CLOSE = 52;

	/**@Fields ERR_FILEOP_READ: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_FILEOP_READ = 53;

	/**@Fields ERR_FILEOP_WRITE: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_FILEOP_WRITE = 54;

	/**@Fields ERR_FILE_NOTFOUND: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_FILE_NOTFOUND = 55;

	/**@Fields ERR_URL_MALFORMED: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_URL_MALFORMED = 110;

	/**@Fields ERR_NET_OPENSTREAM: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_NET_OPENSTREAM = 111;

	/**@Fields ERR_USER_NOTLOGIN: TODO[用一句话描述这个变量表示什么]   */
	public static final int ERR_USER_NOTLOGIN = 99;

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param:  	@param _errNo  
	 */
	public BusinessException(int _errNo) {
		rootCause = null;
		errNo = _errNo;
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param:  	@param _errNo
	 * @param:  	@param _sMsg  
	 */
	public BusinessException(int _errNo, String _sMsg) {
		super(_sMsg);
		sMsg = _sMsg;
		rootCause = null;
		errNo = _errNo;
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param:  	@param _sMsg
	 * @param:  	@param _rootCause  
	 */
	public BusinessException(String _sMsg, Throwable _rootCause) {
		super(_sMsg);
		sMsg = _sMsg;
		errNo = 0;
		rootCause = _rootCause;
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param:  	@param _errNo
	 * @param:  	@param _sMsg
	 * @param:  	@param _rootCause  
	 */
	public BusinessException(int _errNo, String _sMsg, Throwable _rootCause) {
		super(_sMsg);
		sMsg = _sMsg;
		errNo = _errNo;
		rootCause = _rootCause;
	}

	/**@Title: 		 getErrNo   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @return      
	 * @return_type: int      
	 */
	public int getErrNo() {
		return errNo;
	}

	/**@Title: 		 getRootCause   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @return      
	 * @return_type: Throwable      
	 */
	public Throwable getRootCause() {
		return rootCause;
	}

	/**@Title: 		 getErrNoMsg   
	 * @Description: TODO[自定义异常码翻译]   
	 * @return      
	 * @return_type: String      
	 */
	public String getErrNoMsg() {
		switch (errNo) {
		case 1: // '\001'
			return "自定义异常 " + sMsg;
		case 2: // '\002'
			return "数据转换错误";
		case 10: // '\n'
			return "参数错误";
		case 20: // '\024'
			return "空指针错误";
		case 30: // '\036'
			return "数学运算异常";
		case 40: // '('
			return "数据库操作异常";
		case 41: // ')'
			return "获取数据库连接失败";
		case 50: // '2'
			return "文件操作异常";
		case 51: // '3'
			return "打开文件失败";
		case 52: // '4'
			return "关闭文件失败";
		case 53: // '5'
			return "读文件失败";
		case 54: // '6'
			return "写文件失败";
		case 55: // '7'
			return "文件未找到";
		case 56:
			return "文件内容格式错误";
		case 97:
			return "数据库忙";
		case 98:
			return "非业务受理时间";
		case 99: //
			return "用户未登录或登录超时";
		case 100:
			return "非https登录";
		case 101:
			return "中心用户ip地址错误";
		case 110: // 'n'
			return "无效URL";
		case 111: // 'o'
			return "打开网络数据流失败";
		case 201:
			return "无该笔业务";
		case 202:
			return "身份证号不符";
		}
		return "未知错误";
	}

	/**@Title: 		 getMyMessage   
	 * @Description: TODO[获得异常信息]   
	 * @return      
	 * @return_type: String      
	 */
	public String getMyMessage() {
		return super.getMessage();
	}

	/**Title: getMessage
	 * Description:[获得异常信息]
	 * @return   
	 * @see java.lang.Throwable#getMessage()   
	 */
	/*public String getMessage() {
		if (rootCause == null)
			return String.valueOf(
					String.valueOf((new StringBuffer("[")).append(errNo).append("]").append(super.getMessage())));
		else
			return String.valueOf(String.valueOf((new StringBuffer("[")).append(errNo).append("]")
					.append(super.getMessage()).append(";\r\n <-- ").append(rootCause.toString())));
	}*/

	/**Title: getLocalizedMessage
	 * Description:[获取本地化异常信息]
	 * @return   
	 * @see java.lang.Throwable#getLocalizedMessage()   
	 */
	public String getLocalizedMessage() {
		return getMessage();
	}

	/**Title: printStackTrace
	 * Description:[打印堆栈日志]
	 * @param _ps   
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)   
	 */
	public void printStackTrace(PrintStream _ps) {
		if (rootCause == null)
			super.printStackTrace(_ps);
		else
			synchronized (_ps) {
				_ps.println(this);
				rootCause.printStackTrace(_ps);
			}
	}

	/**Title: printStackTrace
	 * Description:[打印堆栈日志]
	 * @param _pw   
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)   
	 */
	public void printStackTrace(PrintWriter _pw) {
		if (rootCause == null)
			super.printStackTrace(_pw);
		else
			synchronized (_pw) {
				_pw.println(this);
				rootCause.printStackTrace(_pw);
			}
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param key  
	 */
	public BusinessException(String msg) {
		super(msg);
		this.sMsg = msg;
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param key
	 * @param value0  
	 */
	public BusinessException(String key, Object value0) {
		this.key = key;
		this.values = new Object[] { value0 };
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param key
	 * @param value0
	 * @param value1  
	 */
	public BusinessException(String key, Object value0, Object value1) {
		this.key = key;
		this.values = new Object[] { value0, value1 };
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param key
	 * @param value0
	 * @param value1
	 * @param value2  
	 */
	public BusinessException(String key, Object value0, Object value1, Object value2) {
		this.key = key;
		this.values = new Object[] { value0, value1, value2 };
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param key
	 * @param value0
	 * @param value1
	 * @param value2
	 * @param value3  
	 */
	public BusinessException(String key, Object value0, Object value1, Object value2, Object value3) {
		this.key = key;
		this.values = new Object[] { value0, value1, value2, value3 };
	}

	/**@Title:  	BusinessException   
	 * @Description:TODO[BusinessException 构造器]   
	 * @param key
	 * @param values  
	 */
	public BusinessException(String key, Object[] values) {
		this.key = key;
		this.values = values;
	}

	// ----------------------------------------------------- Instance Variables
	/**@Fields key: TODO[异常码]   */
	protected String key = null;

	/**@Fields values: TODO[异常信息入参集]   */
	protected Object values[] = null;

	// --------------------------------------------------------- Public Methods
	/**@Title: 		 getKey   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @return      
	 * @return_type: String      
	 */
	public String getKey() {
		return (this.key);
	}

	/**@Title: 		 getValues   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @return      
	 * @return_type: Object[]      
	 */
	public Object[] getValues() {
		return (this.values);
	}

}
