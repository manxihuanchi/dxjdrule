package cho.carbon.test.biz.family;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cho.carbon.biz.constant.EnumKeyValue;
import cho.carbon.context.core.FusionContext;
import cho.carbon.context.hc.HCFusionContext;
import cho.carbon.entity.entity.Entity;
import cho.carbon.panel.Discoverer;
import cho.carbon.panel.Integration;
import cho.carbon.panel.IntegrationMsg;
import cho.carbon.panel.PanelFactory;


@ContextConfiguration(locations = "classpath*:spring-core.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FamilyTest {
	
	private static Logger logger = Logger.getLogger(FamilyTest.class);
	protected String mapperName = "家庭信息";
	
	
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
			logger.debug((float) (endTime - startTime) / 1000);
	}
	
	private Entity createEntity(String mappingName) {
		
		Entity entity = new Entity(mappingName);
		//entity.putValue("唯一编码", "8050e272022a462b984c32b9b20465cf");
		entity.putValue("家庭分类", EnumKeyValue.ENUM_家庭分类_户籍家庭); 
		entity.putValue("家庭地址", "杭州市西湖区6009号");
		
//		Entity relationentity = new Entity("户籍成员");
//		//relationentity.putValue("唯一编码", "687fafa97c0f491aaa3dd86e94220618");
//		relationentity.putValue("姓名", "刘乐乐");
//		relationentity.putValue("身份证号码", "34343434");
//		entity.putRelationEntity("户籍成员", "成员", relationentity);
//	
		
		
		return entity;
	}
	
}
