package ratings;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.SongTitleComparator;

public class Playlist {

    private Comparator<Song> comparator;
    private BinaryTreeNode<Song> root = null;

    private LinkedListNode<Song> returnList = new LinkedListNode<Song>(null, null);
    private LinkedListNode<Song> dummyNode = returnList;

    public Playlist(Comparator<Song> comparator) {
        this.comparator = comparator;
    }

    public void addSong(Song song) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(song, null, null);
        } else {
            this.addSongHelper(this.root, song);
        }
    }

    private void addSongHelper(BinaryTreeNode<Song> node, Song toAdd) {
        if (this.comparator.compare(toAdd, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toAdd, null, null));
            } else {
                addSongHelper(node.getLeft(), toAdd);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toAdd, null, null));
            } else {
                addSongHelper(node.getRight(), toAdd);
            }
        }
    }

    public BinaryTreeNode<Song> getSongTree() {
        return this.root;
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> root) {
        return getSongListHelper(root);
        }

    private LinkedListNode getSongListHelper(BinaryTreeNode<Song> node) {
        //assume the binary tree is balanced bc its a BST so use a in order traversal to get all the shit in a linked list,
        if (node == null) {
            return null;
        }
        getSongListHelper(node.getLeft());
        returnList.setNext(new LinkedListNode<Song>(node.getValue(), null));
        returnList = returnList.getNext();
        getSongListHelper(node.getRight());

        return dummyNode.getNext();
    }

    public LinkedListNode<Song> getSongList() {
        return getSongList(this.root);
    }



}
