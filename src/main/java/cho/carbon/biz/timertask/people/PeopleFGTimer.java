package cho.carbon.biz.timertask.people;

import cho.carbon.biz.bnb.PeopleFG;
import cho.carbon.biz.common.KIEHelper;
import cho.carbon.biz.common.SessionFactory;
import cho.carbon.complexus.FGRecordComplexus;
import cho.carbon.context.fg.FuncGroupContext;
import cho.carbon.fuse.fg.ImproveFGResult;
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
	public ImproveFGResult preImprove(FuncGroupContext context, String recordCode, OpsComplexus opsComplexus,
			FGRecordComplexus recordComplexus) {

		return null;
	}
	
	@Override
	public ImproveFGResult improve(FuncGroupContext context, String recordCode, FGRecordComplexus recordComplexus) {
		
		return KIEHelper.getImproveFGResultFromKIE(context, recordCode, recordComplexus,
				SessionFactory.findScannerSession("ks-dxjde2020-f2-imptimer"));
	}
	
	@Override
	public boolean afterFusition(FuncGroupContext context, String recordCode) {
		return false;
	}
	
	@Override
	public ImproveFGResult postImprove(FuncGroupContext context, String recordCode, FGRecordComplexus recordComplexus) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ImproveFGResult secondImprove(FuncGroupContext context, String recordCode,
			FGRecordComplexus recordComplexus) {
		
		return KIEHelper.getImproveFGResultFromKIE(context, recordCode, recordComplexus,
				SessionFactory.findScannerSession("ks-dxjde2020-imp-second"));
	}
	
	
}
