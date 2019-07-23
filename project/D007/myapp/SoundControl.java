package myapp;
import java.util.LinkedList;

import javax.sound.sampled.*;

public class SoundControl {
	private void VolumeControl(){}

    private static LinkedList<Line> speakers = new LinkedList<Line>();

    private final static void findSpeakers()
    {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();

        for (Mixer.Info mixerInfo : mixers)
        {
//        	System.out.print(mixerInfo.getName());
            if(!mixerInfo.getName().equals("Realtek Digital Output (Realtek High Definition Audio)")) continue;
            System.out.print(mixerInfo.getName());
            Mixer mixer         = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lines   = mixer.getSourceLineInfo();

            for (Line.Info info : lines)
            {

                try 
                {
                    Line line = mixer.getLine(info);
                    speakers.add(line);

                }
                catch (LineUnavailableException e)      { e.printStackTrace();                                                                                  } 
                catch (IllegalArgumentException iaEx)   {                                                                                                       }
            }
        }
    }

    static
    {
        findSpeakers();
    }

    public static void setVolume(float level)
    {
        
        for(Line line : speakers)
        {
            try
            {
            	
                line.open();
                FloatControl control = (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
//                System.out.print(limit(control,level));
                control.setValue((float)6.0206);
                System.out.println("setting volume to "+level);
            }
            catch (LineUnavailableException e) { continue; }
            catch(java.lang.IllegalArgumentException e) { continue; }
            



        }
    }

    private static float limit(FloatControl control,float level)
    { return Math.min(control.getMaximum(), Math.max(control.getMinimum(), level)); }
}
