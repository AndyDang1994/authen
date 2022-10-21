/**
 * 
 */
package com.hacorp.authen.core.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hacorp.authen.core.exception.ServiceRuntimeException;

/**
 * @author shds01
 *
 */
public class CommonUtil {
	public static final String INPUT = "input";
	public static final String INVALID_INPUT = "input-invalid";
	public static final String INPUT2 = "input2";
	public static final String INVALID_INPUT2 = "input2-invalid";
	public static final String RESULTS = "results";
	public static final String VALID = "valid";

	protected static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	public static Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").setPrettyPrinting().create();
	public static ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private transient static Environment env;
	
	public static void main(String[] args) {
		
		logger.info("isNumber : " + isCurrencyAmt("-15461231"));
		logger.info("isNumber : " + isCurrencyAmt("f100,000,546,111.00"));
		
		Collection<File> files = getBankStatementFileInFolder("/Users/dangkimhhoang/Downloads/omsrecon");
		for (File file : files) {
			File des = new File("/Users/dangkimhhoang/Downloads/bkomsrecon");
			moveFileToDirectory(file, des);
		}
		
	
	}
	
	
	public static String base64UrlDecode(String input) {
		String result = null;
		byte[] decodedBytes = Base64.getDecoder().decode(input);
		result = new String(decodedBytes);
		return result;
	}

	public static String toJson(final Object object) throws ServiceRuntimeException {
		try {
			return gson.toJson(object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(env.getProperty("MSG_009"), e.getCause());
		}
	}

	public static Object toPojo(final String jsonString, final Class<?> clazz) throws ServiceRuntimeException {
		try {
			return gson.fromJson(jsonString, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(env.getProperty("MSG_009"), e.getCause());
		}
	}
	
	public static <T> List<T> toListPojo(final String jsonArray, final Class<T> clazz) throws ServiceRuntimeException {
		try {
			return gson.fromJson(jsonArray, TypeToken.getParameterized(List.class, clazz).getType());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(env.getProperty("MSG_009"), e.getCause());
		}
	}

	/**
	 * Should use #clonePojo()(Meaningful and easier to understand) instead of this one
	 * @param json
	 * @param clazz
	 * @return Object
	 * @throws ServiceRuntimeException
	 */
	public static Object toPojo(final Object json, final Class<?> clazz) throws ServiceRuntimeException {
		try {
			return gson.fromJson(toJson(json), clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(env.getProperty("MSG_009"), e.getCause());
		}
	}
	
	/**
	 * This util use json to do a deep clone of an object
	 * With other object different than entity(prevent hibernate automatic persist that instante?) 
	 * or just want an shallow clone should implement interface Cloneable instead of using this one
	 * @param objectToClone
	 * @return the cloned object
	 * @throws ServiceRuntimeException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T clonePojo(final T objectToClone) throws ServiceRuntimeException {
		try {
			return (T) gson.fromJson(toJson(objectToClone), objectToClone.getClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(env.getProperty("MSG_009"), e.getCause());
		}
	}

	public static boolean saveFile(InputStream inputStream, String fileName, String filePath)
			throws ServiceRuntimeException {
		boolean isFile = false;
		OutputStream outputStream = null;
		try {
			File files = new File(filePath);
			if (!files.exists()) {
				if (!files.mkdirs())
					;
			}
			String fileNameToCreate = (filePath + fileName);
			File fileSave = new File(fileNameToCreate);
			outputStream = new FileOutputStream(fileSave);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
			isFile = true;
			outputStream.close();
			logger.info("Save file : " + isFile + " " + fileNameToCreate);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(env.getProperty("MSG_002"), e.getCause());
		}
		return isFile;
	}
	
	public static void deleteFile(File file) {
		
		try {
			FileUtils.forceDelete(file);
		} catch (IOException e) {
			logger.info("***** Delete file error {} " + CommonUtil.getLogMessenge(e) + " *****", file.getName());
		}
		
	}
	
	public static void copyFile(File input, File output) throws IOException{
		FileUtils.copyFile(input, output);
		logger.info("Copy file " + input.getName() + " from " + input.getPath());
		logger.info("To file " + output.getName() + " from " + output.getPath());
	}
	
	public static void moveFileToDirectory(File srcFile, File desFile) {
		try {
			FileUtils.moveFileToDirectory(srcFile, desFile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void moveFileToDirectory(File srcFile, File desFile, String fileName) {
		try {
			String srcFileName = srcFile.getName();
			FileUtils.moveFileToDirectory(srcFile, desFile, true);
			File fileNew = new File(desFile + "/" + srcFileName);
			if(fileNew.exists()) {
				fileNew.renameTo(new File(desFile + "/" + fileName));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String toUpperCase(String input) {
		return StringUtils.isNotBlank(input) ? input.toUpperCase() : "";
	}
	
	public static String toLowerCase(String input) {
		return StringUtils.isNotBlank(input) ? input.toLowerCase() : "";
	}
	
	public static Collection<File> getBankStatementFileInFolder(String dirFolder){
		String[] types = {"xlsx", "xls", "dat"};
		
		File files = new File(dirFolder);
		if (!files.exists()) {
			return new ArrayList<File>();
		}
		return FileUtils.listFiles(new File(dirFolder), types, true);
	}
	
	public static String getLogMessenge(Exception e) {
		String error = null;
		try {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			error =  sw.toString();
		} catch (Exception e2) {
			e2.printStackTrace();
			return e.getMessage();
		}
		return error;
	}
	
	/**
	 * This function help set a value into a field of an object
	 * Support multiple level on an Object (separate by an ".")
	 * Important note:
	 * 	- if a field is a List if will add value inside that List if the type is match
	 *  - it also check the super class, mean if the class extend another class it is automatically cared
	 *  - swallow exception so best practice is check the boolean response
	 * @param object
	 * @param fieldName
	 * @param fieldValue
	 * @return boolean
	 */
	public static <T,V> Boolean setPropertyIntoObject(T object, V fieldValue, String fieldName) {
		return setPropertyIntoObjectHandler(object, fieldValue, fieldName.split("\\."));
	}
	
	
	private static <T,V> Boolean setPropertyIntoObjectHandler(T object, V fieldValue, String... fieldName) {
		if(object == null || fieldValue == null || ArrayUtils.isEmpty(fieldName)) {
			return false;
		}
		if(fieldName.length == 1) {
			return setPropertyIntoObjectHandler(object, fieldValue, fieldName[0]);
		} else {
			try {
				Field field = getField(object, fieldName[0]);
				if(field == null) return false;
				Object subObject = Optional.ofNullable(field.get(object)).orElse(Class.forName(field.getType().getName()).newInstance());
				boolean isSucess = setPropertyIntoObjectHandler(subObject, fieldValue, Arrays.copyOfRange(fieldName, 1, fieldName.length));
				if (isSucess) {
					field.set(object, subObject);
				}
				return isSucess;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T,V> Boolean setPropertyIntoObjectHandler(T object, V fieldValue, String fieldName) {
		if(object == null || fieldValue == null || StringUtils.isBlank(fieldName)) {
			return false;
		}
		try {
			Field field = getField(object, fieldName);
			if (field == null)
				return false;

			if (field.getType().equals(fieldValue.getClass())) {
				field.set(object, fieldValue);
				return true;
			}
			boolean islistWithSameType = field.getType().equals(List.class)
					&& ((Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0])
							.equals(fieldValue.getClass());
			if (islistWithSameType) {
				List<V> currentValue = Optional.ofNullable((List<V>) field.get(object)).orElse(new ArrayList<>());
				currentValue.add(fieldValue);
				field.set(object, currentValue);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static <T> Field getField(T object, String fieldName) {
		Class clazz = object.getClass();
		while (clazz != null) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field;
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		String message = String.format("Property: \"%s\" not available on %s", fieldName, object.getClass().getName());
		logger.error(message);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@SafeVarargs
	public static <T> List<T> joinList(final List<? extends T>...lists){
		if(lists.length == 1) {
			return (List<T>) Optional.ofNullable(lists[0]).orElse(new ArrayList<>());
		}
		final ArrayList<T> result = new ArrayList<>();
		result.addAll(Optional.ofNullable(lists[0]).orElse(new ArrayList<>()));
		result.addAll(joinList(Arrays.copyOfRange(lists, 1, lists.length)));
		return result;
	}
	
	
	public static <T> List<T> getDiffStmtList(List<T> srcList, List<T> desList){
		List< T> rsInfs  = new ArrayList<>();
		rsInfs.addAll(srcList);
		rsInfs.removeAll(desList);
		return rsInfs;
	}
	
	
	public static boolean isNumber(String strNum) {
		if (strNum == null) {
	        return false; 
	    }
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	    return pattern.matcher(strNum).matches();
	}
	public static boolean isCurrencyAmt(String strNum) {
		if (strNum == null) {
			return false; 
		}
		Pattern pattern = Pattern.compile("^[\\$|-]?([0-9]{1,3},([0-9]{3},)*[0-9]{3}|[0-9]+)(.[0-9][0-9])?$");
		return pattern.matcher(strNum).matches();
	}
	public static void cleanFileInFolder(String filePath) throws IOException {
		try {
			File file = new File(filePath);
			if (file.exists()) {
				if(file.isDirectory()) {
					FileUtils.cleanDirectory(file);
					logger.info("Clean Folder : " + file + " Done");
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String md5(String val) {
		String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(val.getBytes("UTF-8"));
            // converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (UnsupportedEncodingException ex) {
            digest = "";
            // Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE,
            // null, ex);
        } catch (NoSuchAlgorithmException ex) {
            // Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE,
            // null, ex);
            digest = "";
        }
        return digest;
	}
	
	public static String Sha256(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(message.getBytes("UTF-8"));

            // converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }

            digest = sb.toString();

        } catch (UnsupportedEncodingException ex) {
            digest = "";
            // Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE,
            // null, ex);
        } catch (NoSuchAlgorithmException ex) {
            // Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE,
            // null, ex);
            digest = "";
        }
        return digest;
    }
    
    public static String hmacSHA512(final String key, final String data) {
        try {

            if (key == null || data == null) {
                throw new NullPointerException();
            }
            final Mac hmac512 = Mac.getInstance("HmacSHA512");
            byte[] hmacKeyBytes = key.getBytes();
            final SecretKeySpec secretKey = new SecretKeySpec(hmacKeyBytes, "HmacSHA512");
            hmac512.init(secretKey);
            byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
            byte[] result = hmac512.doFinal(dataBytes);
            StringBuilder sb = new StringBuilder(2 * result.length);
            for (byte b : result) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();

        } catch (Exception ex) {
            return "";
        }
    }
    
	public static <T> T jsonToPojo(final String jsonString, final Class<T> clazz) throws ServiceRuntimeException {
		try {
			return gson.fromJson(jsonString, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(env.getProperty("MSG_004"), e.getCause());
		}
	}
}
