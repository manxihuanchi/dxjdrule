package cho.carbon.test.biz.people;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cho.carbon.biz.constant.EnumKeyValue;
import cho.carbon.context.core.FusionContext;
import cho.carbon.context.hc.HCFusionContext;
import cho.carbon.entity.entity.Entity;
import cho.carbon.entity.entity.LeafEntity;
import cho.carbon.panel.Discoverer;
import cho.carbon.panel.Integration;
import cho.carbon.panel.IntegrationMsg;
import cho.carbon.panel.PanelFactory;

/**
 * 测试残疾信息
 * @author chuyin
 *
 */
@ContextConfiguration(locations = "classpath*:spring-core.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DisabilityTest {
	
	Logger logger = LoggerFactory.getLogger(DisabilityTest.class);	
	protected String mapperName = "人口信息";
	
	@Test
	public void readData() {
		
			long startTime = System.currentTimeMillis();
			HCFusionContext context=new HCFusionContext();
			context.setSource(FusionContext.SOURCE_COMMON);
//			context.setToEntityRange(BizFusionContext.ENTITY_CONTENT_RANGE_ABCNODE_CONTAIN);
			context.setStrucTitle(mapperName);
			context.setUserCode("e10adc3949ba59abbe56e057f28888d5");
			Integration integration=PanelFactory.getIntegration();
			Entity entity=createEntity(mapperName);
			logger.debug("初始实体： " + entity.toJson());
			IntegrationMsg imsg=integration.integrate(context,entity);
			String code=imsg.getCode();
			Discoverer discoverer=PanelFactory.getDiscoverer(context);
			Entity result=discoverer.discover(code);
			logger.debug("融合后实体： " + code + " : "+ result.toJson());
			
			long endTime = System.currentTimeMillis();// 记录结束时间
			logger.debug(((endTime - startTime) / 1000) + "");
	}
	
	private Entity createEntity(String mappingName) {
		
		Entity entity = new Entity(mappingName);
		//entity.putValue("唯一编码", "8050e272022a462b984c32b9b20465cf");
		entity.putValue("姓名", "测试194"); 
		//110101193903074918
		//110101199003077598
		entity.putValue("身份证号码", "110101193903074918");//110101199003077598
		Collection<Integer> coll = new ArrayList<Integer>();
		coll.add(30703);
		coll.add(30708);
//		entity.putValue("身份类别", coll);
		entity.putValue("身份类别", "30703,30708");
		
		
		// 二维组， 多行属性
	  LeafEntity sentity2 = new LeafEntity("残疾信息"); 
	  sentity2.putValue("残疾类别",  EnumKeyValue.ENUM_残疾类别_听力); 
	  sentity2.putValue("残疾等级",	  EnumKeyValue.ENUM_等级_一级); 
	  entity.putGroup2DEntity(sentity2);
		
		return entity;
	}

	
	
}
