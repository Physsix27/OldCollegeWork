/*
Starlyn Urena
Prof. 
csc 210
09/16/15
**************
#LAB
The purpose of this class is to model a television
**************
*/
public class TelevisionClass 
{
   private String Manufacturer; //the maker of the television
   private int SCREEN_SIZE; //the size of the screen
   private boolean powerOn; //contains true if the TV power is on
   private int channel; //the numeric station setting
   private int volume; //the numeric level of the sound
    
   //Constructor creates a television with given brand and size
    public TelevisionClass(String mBrand, int sSize)
    {
        Manufacturer = mBrand;
        SCREEN_SIZE = sSize;
        powerOn = !powerOn;
        volume = 20;
    }
    
   //mutator method stores the desired station in the channel field
    public void setChannel(int station)
    {
        channel = station;
    }
    
   //puts the power on and of
    public void power()
    {
        powerOn = !powerOn;
    }
    
   //increases the volume by one
    public void increaseVolume()
    {
        volume += 1;
    }
    
   //decreased the volume by one
    public void decreaseVolume()
    {
        volume -= 1;
    }
    
    public void decraceVolumeByTwo()
    {
        volume -= 2;
    }
    
   //accessor method returns the current channel
    public int getChannel()
    {
        return channel;
    }
    
   //accessor method returns the current volume
    public int getVolume()
    {
        return volume;
    }
    
   //accessor method returns the makers name
    public String getManufacturer()
    {
        return Manufacturer;
    }
    
   //accessor method returns the screen size
    public int getScreenSize()
    {
     return SCREEN_SIZE;    
    }
}