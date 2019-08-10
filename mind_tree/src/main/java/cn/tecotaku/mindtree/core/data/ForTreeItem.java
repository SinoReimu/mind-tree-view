package cn.tecotaku.mindtree.core.data;

import java.io.Serializable;


public interface ForTreeItem<T extends NodeModel<?>> extends Serializable {
    void next(int msg, T next);
}
