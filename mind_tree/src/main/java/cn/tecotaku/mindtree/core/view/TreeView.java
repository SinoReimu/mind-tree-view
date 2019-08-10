package cn.tecotaku.mindtree.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import cn.tecotaku.mindtree.core.data.TreeModel;
import cn.tecotaku.mindtree.layoutmanager.TreeLayoutManager;

public class TreeView extends FrameLayout {

    private TreeViewCore core;

    public TreeView(Context context) {
        this(context, null, 0);
    }

    public TreeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        core = new TreeViewCore(context);
        addView(core);
    }

    public void setTreeLayoutManager(TreeLayoutManager treeLayoutManager) {
        core.setTreeLayoutManager(treeLayoutManager);
    }

    public void setTreeModel(TreeModel<String> tree) {
        core.setTreeModel(tree);
    }


    public void setTreeViewItemClick(TreeViewCore.TreeViewItemClick treeViewItemClick) {
        core.setTreeViewItemClick(treeViewItemClick);
    }

    public void setTreeViewItemLongClick(TreeViewCore.TreeViewItemLongClick treeViewItemLongClick) {
        core.setTreeViewItemLongClick(treeViewItemLongClick);
    }
}
