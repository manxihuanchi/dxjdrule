package cho.carbon.biz.tool;

import java.util.Collection;

import cho.carbon.fuse.improve.attribute.FuseAttribute;
import cho.carbon.fuse.improve.attribute.FuseAttributeFactory;
import cho.carbon.fuse.improve.attribute.leaf.FuseLeafAttribute;
import cho.carbon.rrc.record.Attribute;
import cho.carbon.rrc.record.FGAttribute;

public class FGFuseAttributeFactory {
	public static FuseLeafAttribute buildFuseLeafAttribute(String rootCode, String leafName, String leafCode,
			Attribute attribute) {
		return FuseAttributeFactory.buildFuseLeafAttribute(rootCode, leafName, leafCode, attribute);
	}

	public static Collection<FuseLeafAttribute> buildFuseLeafAttribute(String rootCode, String leafName,
			Collection<Attribute> attributes) {
	
		return FuseAttributeFactory.buildFuseLeafAttribute(rootCode, leafName, attributes);
	}

	public static FuseLeafAttribute buildFuseLeafAttribute(String rootCode, String leafName, String leafCode,
			String leafAttrName, Object leafAttrValue) {
		return FuseAttributeFactory.buildFuseLeafAttribute(rootCode, leafName, leafCode, leafAttrName, leafAttrValue);
	}

	public static FGAttribute buildAttribute(String itemCode, Object value) {
		return FuseAttributeFactory.buildAttribute(itemCode, value);
	}

	public static FuseAttribute buildFuseAttribute(String rootCode, String itemCode, Object value) {
		return FuseAttributeFactory.buildFuseAttribute(rootCode, itemCode, value);
	}
}
