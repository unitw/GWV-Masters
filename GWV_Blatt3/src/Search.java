import java.util.Stack;

public class Search {

	private final char GOAL_CHAR = 'g';
	private final char START_CHAR = 's';
	private final char UP = 'u';
	private final char RIGHT = 'r';
	private final char DOWN = 'd';
	private final char LEFT = 'l';

	private char[][] _environment;
	private int _startPosX;
	private int _startPosY;

	private int _currentPosX;
	private int _currentPosY;

	private Stack<Character> _searchStack;

	// public static String dfs(char[][] environment, int xLength, int yLength,
	// int startPosX, int startPosY)
	// {
	// Search search = new Search(environment, xLength, yLength, startPosX,
	// startPosY);
	// return "";
	// }

	public Search(char[][] environment, int xLength, int yLength,
			int startPosX, int startPosY) {
		_environment = environment;
		_startPosX = startPosX;
		_startPosY = startPosY;
		_currentPosX = startPosX;
		_currentPosY = startPosY;
		_searchStack = new Stack<Character>();
	}

	private char oppositeDirection(char direction) {
		char oppositeDir = ' ';

		switch (direction) {
		case 'u':
			oppositeDir = 'd';
			break;
		case 'r':
			oppositeDir = 'l';
			break;
		case 'd':
			oppositeDir = 'u';
			break;
		case 'l':
			oppositeDir = 'r';
			break;
		}

		return oppositeDir;
	}

	public Stack<Character> startDFS() {
		_searchStack.push(START_CHAR);
		
		int schleifenzaehler = 0;
		
		while (!goalInReach()) {
			if (topIsClear()) {
				move(UP);
				_environment[_currentPosY][_currentPosX] = UP;
				_searchStack.push(UP);
			} else if (rightIsClear()) {
				move(RIGHT);
				_environment[_currentPosY][_currentPosX] = RIGHT;
				_searchStack.push(RIGHT);
			} else if (bottomIsClear()) {
				move(DOWN);
				_environment[_currentPosY][_currentPosX] = DOWN;
				_searchStack.push(DOWN);
			} else if (leftIsClear()) {
				move(LEFT);
				_environment[_currentPosY][_currentPosX] = LEFT;
				_searchStack.push(LEFT);
			} else {
				char topChar = _searchStack.peek();
				if (topChar != START_CHAR)
				{
					_searchStack.pop();
				}
				move(oppositeDirection(topChar));
			}
			++schleifenzaehler;
			//System.out.println(_searchStack.toString());
			
			for (int y = 0; y < 10; ++y)
			{
				String line = "";
				for (int x = 0; x <20; ++x)
				{
					line = line + _environment[y][x];
				}
				System.out.println(line);
			}
			System.out.println();
		}
		
		System.out.println(schleifenzaehler);
		return _searchStack;
	}

	private void move(char direction) {
		switch (direction) {
		case 'u':
			_currentPosY -= 1;
			break;
		case RIGHT:
			_currentPosX += 1;
			break;
		case DOWN:
			_currentPosY += 1;
			break;
		case LEFT:
			_currentPosX -= 1;
			break;
		}
	}

	// Clear-Methoden

	private boolean topIsClear() {
		return _environment[_currentPosY - 1][_currentPosX] == ' ';
	}

	private boolean bottomIsClear() {
		return _environment[_currentPosY + 1][_currentPosX] == ' ';
	}

	private boolean leftIsClear() {
		return _environment[_currentPosY][_currentPosX - 1] == ' ';
	}

	private boolean rightIsClear() {
		return _environment[_currentPosY][_currentPosX + 1] == ' ';
	}

	// onGoal
	private boolean goalInReach() {
		if (topIsGoal())
		{
			_searchStack.push(UP);
		}
		else if (rightIsGoal())
		{
			_searchStack.push(RIGHT);
		}
		else if (bottomIsGoal())
		{
			_searchStack.push(DOWN);
		}
		else if (leftIsGoal())
		{
			_searchStack.push(LEFT);
		}
		else
		{
			return false;
		}
		
		return true;
	}
	
	private boolean topIsGoal() {
		return _environment[_currentPosY - 1][_currentPosX] == GOAL_CHAR;
	}

	private boolean bottomIsGoal() {
		return _environment[_currentPosY + 1][_currentPosX] == GOAL_CHAR;
	}

	private boolean leftIsGoal() {
		return _environment[_currentPosY][_currentPosX - 1] == GOAL_CHAR;
	}

	private boolean rightIsGoal() {
		return _environment[_currentPosY][_currentPosX + 1] == GOAL_CHAR;
	}
}
