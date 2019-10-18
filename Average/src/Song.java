//This program represents a song
public class Song
{
	private String title; //The title of the song*/
	private String artist; //The artist who sings the song

	/**constructor
	@param title The title of the song
	@param artist The artist who sings the song
	*/
	public Song(String title, String artist)
	{
		this.title = title;
		this.artist = artist;
	}

	/**toString method returns a description of the song
	@return a String containing the name of the song and the artist
	*/
	public String toString()
	{
		return title + " by " + artist + "\n";
	}
}