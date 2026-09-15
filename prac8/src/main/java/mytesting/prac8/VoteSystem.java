package mytesting.prac8;

public class VoteSystem {
	
	private final UserRepository userRepository;
	private final VoteProcessor voteProcessor;
		
	public VoteSystem(UserRepository userRepository, VoteProcessor voteProcessor) {
		super();
		this.userRepository = userRepository;
		this.voteProcessor = voteProcessor;
	}
	
	boolean isValid(UserInfo info) {
		return info.getAge() < 18 && !info.isVoted();
	}

	void vote(String username, String choice) {
		
		UserInfo info = userRepository.getUserInfo(username);
		
		//закоментированный фрагмент кода до рефакторинга 
		//if (isValid(info)) {
		
		if (info.getAge() >= 18 && !info.isVoted()) {
			userRepository.voted(username);
			voteProcessor.process_vote(choice);
		}
	}
	
	boolean canVote(String username, String choice) {
		UserInfo info = userRepository.getUserInfo(username);
		return isValid(info);
	}
}
