package mytesting.prac8;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AppTest {
	@Mock
	private VoteProcessor voteProcessor;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
    public void testApp()
    {
		when(userRepository.getUserInfo("Вася Пупкин")).thenReturn(new UserInfo("Вася Пупкин", 18, false));
		
    	VoteSystem voteSystem = new VoteSystem(userRepository, voteProcessor);
    	
        VoteSystem spy = Mockito.spy(voteSystem);

        spy.vote("Вася Пупкин", "Выбор Васи Пупкина");
        
        verify(voteProcessor).process_vote("Выбор Васи Пупкина");
    }
}

/*
// старый неправильный код теста
package mytesting.prac8;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AppTest {
	@Mock
	private VoteProcessor voteProcessor;
	
	@Test
    public void testApp()
    {
    	VoteSystem voteSystem = new VoteSystem(new UserRepository(), voteProcessor);

        VoteSystem spy = Mockito.spy(voteSystem);
        
        doReturn(true).when(spy).isValid(any());
        
        spy.vote("Вася Пупкин", "Выбор Васи Пупкина");
        
        verify(voteProcessor).process_vote("Выбор Васи Пупкина");
    }
}
*/



