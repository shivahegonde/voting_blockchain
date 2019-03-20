package src.com.blockchain;

import java.io.Serializable;

public class Block implements Serializable
{
	//inner class
	public class Vote implements Serializable
	{
		private String voterId;
		private String voterName;
		private String voteCandidate;

		public Vote(String voterId, String voterName, String voteParty)
		{
			this.voterName=voterName;
			this.voterId=voterId;
			this.voteCandidate =voteParty;
		}

		public String getVoterId() {
			return voterId;
		}

		public void setVoterId(String voterId) {
			this.voterId = voterId;
		}

		public String getVoterName() {
			return voterName;
		}

		public void setVoterName(String voterName) {
			this.voterName = voterName;
		}

		public String getVoteCandidate() {
			return voteCandidate;
		}

		public void setVoteCandidate(String voteCandidate) {
			this.voteCandidate = voteCandidate;
		}
	}

	private Vote voteObj;
	
	private int previousHash;
	private int blockHash;

	public Block(int previousHash, String voterId, String voterName, String voteCandidate)
	{
		this.previousHash=previousHash;
		voteObj=new Vote(voterId, voterName, voteCandidate);

		Object[] contents={voteObj.hashCode(), previousHash};
		this.blockHash=contents.hashCode();
	}

	public Vote getVoteObj() {
		return voteObj;
	}

	public void setVoteObj(Vote voteObj) {
		this.voteObj = voteObj;
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}

	public int getBlockHash() {
		return blockHash;
	}

	public void setBlockHash(int blockHash) {
		this.blockHash = blockHash;
	}
	
	@Override
	public String toString() {
		return "Voter Id:" + this.voteObj.voterId + "\nVoter Name: " + this.voteObj.voterName + "\nVoted for Candidate: " + this.voteObj.voteCandidate;
	}
}