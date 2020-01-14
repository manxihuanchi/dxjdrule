package cho.carbon.biz.timertask;

import java.util.Collection;

import cho.carbon.auth.constant.AuthConstant;
import cho.carbon.context.core.FusionContext;
import cho.carbon.context.hc.HCFusionContext;
import cho.carbon.fuse.fg.FunctionGroup;
import cho.carbon.panel.Integration;
import cho.carbon.panel.PanelFactory;


public class LoadEntityToWorkMemory {
	public static void loadEntity(String modelCode, Collection<String>  codes, FunctionGroup functionaGroup) {
		
		Integration integration=PanelFactory.getIntegration();
		HCFusionContext context=new HCFusionContext();
		context.setModelCode(modelCode);
		// 可选操作， 指定FG, 若不指定， 自动去spring中加载注解的FG
		context.getFunctionGroupContainer().putFunctionGroup(modelCode, functionaGroup);
		context.setUserCode(AuthConstant.SUPERCODE);
		context.setSource(FusionContext.SOURCE_COMMON);
		
		if(codes!=null) {
			for(String code :codes) {
				integration.integrate(context,code);
			}
		}
	}
	
}
