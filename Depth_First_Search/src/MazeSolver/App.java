package MazeSolver;

public class App {

	public static void main(String[] args) {
		
		FileReader fileReader = new FileReader("E:\\windows\\de.viitor\\java\\installed.softwares\\eclipse.workplace\\Advanced_Algorithms_in_Java\\Depth_First_Search\\src\\map.txt", 5, 5);
		fileReader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(),fileReader.getStartPositionRow(),fileReader.getStartPositionCol());
		mazeSolver.findWayOut();
		
	}
}
