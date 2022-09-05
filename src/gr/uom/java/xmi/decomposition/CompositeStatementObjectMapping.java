package gr.uom.java.xmi.decomposition;

import gr.uom.java.xmi.VariableDeclarationContainer;
import gr.uom.java.xmi.diff.StringDistance;

public class CompositeStatementObjectMapping extends AbstractCodeMapping implements Comparable<CompositeStatementObjectMapping> {

	private double compositeChildMatchingScore;
	
	public CompositeStatementObjectMapping(CompositeStatementObject statement1, CompositeStatementObject statement2,
			VariableDeclarationContainer operation1, VariableDeclarationContainer operation2, double score) {
		super(statement1, statement2, operation1, operation2);
		this.compositeChildMatchingScore = score;
	}

	public double getCompositeChildMatchingScore() {
		return compositeChildMatchingScore;
	}

	@Override
	public int compareTo(CompositeStatementObjectMapping o) {
		if(this.compositeChildMatchingScore >= 2.0*o.compositeChildMatchingScore) {
			return -Double.compare(this.compositeChildMatchingScore, o.compositeChildMatchingScore);
		}
		double distance1;
		double distance2;
		if(this.getFragment1().getString().equals(this.getFragment2().getString())) {
			distance1 = 0;
		}
		else {
			String s1 = this.getFragment1().getString().toLowerCase();
			String s2 = this.getFragment2().getString().toLowerCase();
			int distance = StringDistance.editDistance(s1, s2);
			distance1 = (double)distance/(double)Math.max(s1.length(), s2.length());
		}
		
		if(o.getFragment1().getString().equals(o.getFragment2().getString())) {
			distance2 = 0;
		}
		else {
			String s1 = o.getFragment1().getString().toLowerCase();
			String s2 = o.getFragment2().getString().toLowerCase();
			int distance = StringDistance.editDistance(s1, s2);
			distance2 = (double)distance/(double)Math.max(s1.length(), s2.length());
		}
		
		if(distance1 != distance2) {
			if(this.isIdenticalWithExtractedVariable() && !o.isIdenticalWithExtractedVariable()) {
				return -1;
			}
			else if(!this.isIdenticalWithExtractedVariable() && o.isIdenticalWithExtractedVariable()) {
				return 1;
			}
			if(this.isIdenticalWithInlinedVariable() && !o.isIdenticalWithInlinedVariable()) {
				return -1;
			}
			else if(!this.isIdenticalWithInlinedVariable() && o.isIdenticalWithInlinedVariable()) {
				return 1;
			}
			return Double.compare(distance1, distance2);
		}
		else {
			if(this.compositeChildMatchingScore != o.compositeChildMatchingScore) {
				return -Double.compare(this.compositeChildMatchingScore, o.compositeChildMatchingScore);
			}
			else {
				int depthDiff1 = Math.abs(this.getFragment1().getDepth() - this.getFragment2().getDepth());
				int depthDiff2 = Math.abs(o.getFragment1().getDepth() - o.getFragment2().getDepth());

				if(depthDiff1 != depthDiff2) {
					return Integer.valueOf(depthDiff1).compareTo(Integer.valueOf(depthDiff2));
				}
				else {
					int indexDiff1 = Math.abs(this.getFragment1().getIndex() - this.getFragment2().getIndex());
					int indexDiff2 = Math.abs(o.getFragment1().getIndex() - o.getFragment2().getIndex());
					if(indexDiff1 != indexDiff2) {
						return Integer.valueOf(indexDiff1).compareTo(Integer.valueOf(indexDiff2));
					}
					else {
						int locationSum1 = this.getFragment1().getLocationInfo().getStartLine() + this.getFragment2().getLocationInfo().getStartLine();
						int locationSum2 = o.getFragment1().getLocationInfo().getStartLine() + o.getFragment2().getLocationInfo().getStartLine();
						return Integer.valueOf(locationSum1).compareTo(Integer.valueOf(locationSum2));
					}
				}
			}
		}
	}
}
