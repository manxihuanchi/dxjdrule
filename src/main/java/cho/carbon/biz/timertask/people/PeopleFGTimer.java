package cho.carbon.biz.timertask.people;

import cho.carbon.biz.bnb.PeopleFG;
import cho.carbon.biz.common.KIEHelper;
import cho.carbon.biz.common.SessionFactory;
import cho.carbon.complexus.FGRecordComplexus;
import cho.carbon.fuse.fg.FGFusionContext;
import cho.carbon.fuse.fg.ImproveResult;
import cho.carbon.hc.HCFusionContext;
import cho.carbon.ops.complexus.OpsComplexus;


public class PeopleFGTimer extends PeopleFG {
	
	/**
	 * true: 只要为true， 任何情况都融合
	 * false: 任何情况都不融合
	 */
	@Override
	public boolean improveEveryTime() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@Override
	public ImproveResult preImprove(FGFusionContext context, String recordCode, OpsComplexus opsComplexus,
			FGRecordComplexus recordComplexus) {
		return null;
	}
	
	@Override
	public ImproveResult improve(FGFusionContext context, String recordCode, FGRecordComplexus recordComplexus) {
		return KIEHelper.getImproveResultFromKIE(context, recordCode, recordComplexus,
				SessionFactory.findScannerSession("ks-people-ipm-ipmTimer"));
	} 
	
	
	@Override
	public boolean afterFusition(String recordCode, HCFusionContext context) {
		return false;
	}
	
	@Override
	public ImproveResult postImprove(FGFusionContext context, String recordCode, FGRecordComplexus recordComplexus) {
		return null;
	}
	

	@Override
	public ImproveResult secondImprove(FGFusionContext context, String recordCode, FGRecordComplexus recordComplexus) {
//		return KIEHelper.getImproveResultFromKIE(context, recordCode, recordComplexus,
//				SessionFactory.findScannerSession("ks-people-secondipm-secondipmTimer"));
		
		return null;
	}
	
}
