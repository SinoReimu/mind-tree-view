package cn.tecotaku.mindtree.layoutmanager;

import cn.tecotaku.mindtree.core.view.NodeView;
import cn.tecotaku.mindtree.core.data.ViewBox;
import cn.tecotaku.mindtree.core.view.TreeViewCore;

public interface TreeLayoutManager {
    /**
     * 进行树形结构的位置计算
     */
    void onTreeLayout(TreeViewCore treeViewCore);

    /**
     * 位置分布好后的回调,用于确认ViewGroup的大小
     */
    ViewBox onTreeLayoutCallBack();

    /**
     * 修正位置
     *
     * @param treeViewCore
     * @param next
     */
    void correctLayout(TreeViewCore treeViewCore, NodeView next);
}
