package cho.carbon.biz.algorithm.people;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cho.carbon.biz.common.CommonCalculation;
import cho.carbon.biz.constant.EnumKeyValue;

public class BirthdayAlgorithm {
	
	private static String date = "yyyy-MM-dd";
	private static String dateTime = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(date);
	
	
	public static Integer getOldLaber(String birthday) throws Exception {
		
		Date parse = sdf.parse(birthday);
		
		return getOldLaber(parse);
	}
	
	/**
	 * 根据老人出生日期获取老人标签
	 * 
	 * @return  60-69岁老人  70-79岁老人
	 */
	@SuppressWarnings("deprecation")
	public static Integer getOldLaber(Date birthday) {
		
		if (!CommonCalculation.isBasicLawful(birthday)) {
			return null;
		}
		
		try {
			Integer age = extractAge(birthday);
			if (age>=100) {
				return EnumKeyValue.ENUM_几岁老人_百岁以上老人;
			}else if (age>=90) {
				return EnumKeyValue.ENUM_几岁老人_90_99岁老人;
			} else if (age>=80) {
				return EnumKeyValue.ENUM_几岁老人_80_89岁老人;
			} else if (age>=70) {
				return EnumKeyValue.ENUM_几岁老人_70_79岁老人;
			} else if (age>=60) {
				return EnumKeyValue.ENUM_几岁老人_60_69岁老人;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 	提取年龄信息
	 * @param id
	 * @return
	 */
	public static Integer extractAge(Date birthday){
		if (!CommonCalculation.isBasicLawful(birthday)) {
			return 0;
		}
		
		try {
			Date birthdayDate = birthday;
			
			//获取当前年， 月
			Calendar ca =Calendar.getInstance();
			int nowYear= ca.get(Calendar.YEAR);
			int nowMonth= ca.get(Calendar.MONTH)+1;
			int nowDay = ca.get(Calendar.DAY_OF_MONTH);
			//获取生日年月
			ca.setTime(birthdayDate);
			int IDYear=ca.get(Calendar.YEAR);
			int IDMonth=ca.get(Calendar.MONTH)+1;
			int IDDay=ca.get(Calendar.DAY_OF_MONTH);
			
			
			//2019 1 24 
			// 2017 1 24
			
			if(IDMonth == nowMonth){//月份相同
				if(nowDay >=IDDay) {//当前天数大
					return nowYear-IDYear;
				} else {
					return nowYear-IDYear-1;
				}
			}else {//月份不同
				if((nowMonth-IDMonth)>0){//当前月大
					return nowYear-IDYear;
				}else {
					return nowYear-IDYear-1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
