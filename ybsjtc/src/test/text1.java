package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.TransformerFactory;

import com.wondersgroup.framework.cxf.centerservice.CommonService;
import com.wondersgroup.framework.cxf.materialservice.MaterialService;
import com.wondersgroup.framework.dbutil.centre.centreJdbcUtil;
import com.wondersgroup.framework.pdfutil.Doc2Pdf;
import com.wondersgroup.framework.util.DESUtil;
import com.wondersgroup.framework.util.EncryptUtil;
import com.wondersgroup.materiel.encoding.service.EncodingService;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import java.io.ByteArrayOutputStream;  
import java.io.InputStream;  
import java.net.HttpURLConnection;  
import java.net.URL;  
import net.sf.json.JSONObject;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [test]
 * @ClassName:    [text1]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年3月16日 上午10:59:45]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年3月16日 上午10:59:45]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class text1 {

	/**@Title: 		 main   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param args      
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws SQLException 
	 * @return_type: void      
	 */
	public static void main(String[] args) throws Exception {
		 Doc2Pdf.doc2pdf("C:\\Users\\Administrator\\Desktop\\周报");
	}
	
}
