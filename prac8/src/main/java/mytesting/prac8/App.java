package mytesting.prac8;

public class App 
{
    public static void main( String[] args )
    {
    	VoteSystem voteSystem = new VoteSystem(new UserRepository(), new VoteProcessor());
    	voteSystem.vote("Вася Пупкин", "Выбор Васи Пупкина");
        System.out.println( "Hello World!");
    }
}
