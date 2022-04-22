

public class TreeNode<T> {

	private T data;
	protected TreeNode<T> l;
	protected TreeNode<T> r;

	public TreeNode(T dataNode) {
		data = dataNode;
		r = null;
		l = null;
	}

	public TreeNode(TreeNode<T> node) {
		l=node.l;
		r=node.r;
		data=node.data;
	}

	public T getData() {
		return data;

	}

	public TreeNode<T> getLeft(){
		return l;
	}

	public TreeNode<T> getRight(){
		return r;
	}

	public void setData(T d) {
		data = d;

	}

	public void setLeft(TreeNode<T> le){
		l =le;
	}

	public void setRight(TreeNode<T> ri){
		r=ri;
	}

}
