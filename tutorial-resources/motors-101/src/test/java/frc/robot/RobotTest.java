package frc.robot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class RobotTest {

    @Mock
    private Robot myRobot;

    @Before
    public void setUp() throws Exception {
        myRobot = new Robot();
    }

    @After
    public void tearDown() throws Exception {
        myRobot = null;
    }

    @Test
    public void testRobotNull() throws Exception{
       assertNotNull(myRobot);
    }

    @Test
    public void testRobotPerioidsNotNull() throws Exception{
        assertNotNull(myRobot.getPeriod());
    }

    @Test
    public void testRobotPerioidsDefault() throws Exception{
       // System.out.println("actual "+myRobot.getPeriod());
        double expectedPeriod = 0.02d;
        assertEquals(expectedPeriod, myRobot.getPeriod(),0);
    }
}