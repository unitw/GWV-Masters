import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class EnvironmentReader {
	
	private final String _location;
	private final int _lineCount;
	private final int _lineLength;
	private final char START_CHAR = 's';
	
	private char[][] _environment;
	private int[] _startPos;
	
	public EnvironmentReader(String location, int lineCount, int lineLength) throws IOException
	{
		_location = location;
		_lineCount = lineCount;
		_lineLength = lineLength;
		
		readEnvironment();
	}
	
	private void readEnvironment() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(_location));
		
		char[][] environment = new char[_lineCount][_lineLength];
		
		for (int currentLine = 0; currentLine < _lineCount; ++currentLine)
		{
			String line = reader.readLine();
			for (int linePos = 0; linePos < line.length(); ++linePos)
			{
				char currentChar = line.charAt(linePos);
				if (currentChar == START_CHAR)
				{
					_startPos = new int[2];
					_startPos[0] = currentLine;
					_startPos[1] = linePos;					
				}
				environment[currentLine][linePos] = currentChar;
			}
		}
		
		reader.close();
		_environment = environment;
	}
	
	public char[][] getEnvironment()
	{
		return _environment;
	}
	
	public int[] getStartPos()
	{
		return _startPos;
	}
	
	public int getStartPosX()
	{
		return _startPos[1];
	}
	
	public int getStartPosY()
	{
		return _startPos[0];
	}
}
