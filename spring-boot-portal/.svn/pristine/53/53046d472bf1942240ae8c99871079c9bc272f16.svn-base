package cn.qfengx.portal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataVerify {
	
	/**
	 * 身份证验证
	 * @param idcard
	 * @return
	 */
	public static boolean idcardVerify(String idcard) {
		if (idcard == null || idcard.isEmpty()) {
			return false;
		}
		String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
	                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
		boolean matches = idcard.matches(regularExpression);
		if (matches) {
            if (idcard.length() == 18) {
                try {
                    char[] charArray = idcard.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
//                        System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() + 
//                                "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
//                    System.out.println("异常:" + cardID);
                    return false;
                }
            }

        }
		return matches;
	}

	/**
	 * ip验证
	 * @param ip
	 * @return
	 */
	public static boolean ipVerify(String ipAddress) {
		String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}"; 
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
	}
}
