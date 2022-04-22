import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MorseCodeTree implements LinkedConverterTreeInterface <String>{
	private TreeNode<String> r;

	MorseCodeTree(){
	buildTree();
	}

	@Override
	public TreeNode<String> getRoot() {
		return r;
	}
	
	@Override
	public void setRoot(TreeNode<String> newNode) {
		r = newNode;
	}
	
	@Override
	public void insert(String code, String result) {
		addNode(r,code,result);

	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) throws NoSuchElementException{
		TreeNode<String> temp = root;
		if(code.length() == 1){
			temp = new TreeNode(letter);
			if(code.equals("-")){
				root.setRight(temp);
			}else{
				root.setLeft(temp);
			}
			return;
		}if(code.charAt(0) == '-'){
			addNode(temp.getRight(),code.substring(1), letter);
		}else if(code.charAt(0) == '.'){
			addNode(temp.getLeft(), code.substring(1), letter);
		}else{
			throw new NoSuchElementException();
		}
	}

	@Override
	public String fetch(String code) {

		return fetchNode(r,code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) throws NoSuchElementException{
		TreeNode<String> temp = root;
		if (code.length() == 0){
			return root.getData();
		} if(code.charAt(0)== '-'){
			return fetchNode(temp.getRight(),code.substring(1));
		} else if (code.charAt(0) == '.'){
			return fetchNode(temp.getLeft(),code.substring(1));
		}else{
			throw new NoSuchElementException();
		}
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}

	@Override
	public void buildTree() {
		r = new  TreeNode<String>("");

		insert(".","e");
		insert("-","t");     
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		insert("....","h");
		insert("...-", "v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> a = new ArrayList<String>();
		LNRoutputTraversal(getRoot(),a);
		return a;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null){
			LNRoutputTraversal(root.getLeft(),list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRight(),list);
		}
	}
}
