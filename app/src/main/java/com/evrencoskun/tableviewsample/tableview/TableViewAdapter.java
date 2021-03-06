package com.evrencoskun.tableviewsample.tableview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.evrencoskun.tableviewsample.R;
import com.evrencoskun.tableviewsample.tableview.holder.CellViewHolder;
import com.evrencoskun.tableviewsample.tableview.holder.ColumnHeaderViewHolder;
import com.evrencoskun.tableviewsample.tableview.holder.RowHeaderViewHolder;
import com.evrencoskun.tableviewsample.tableview.model.Cell;
import com.evrencoskun.tableviewsample.tableview.model.ColumnHeader;
import com.evrencoskun.tableviewsample.tableview.model.RowHeader;

/**
 * Created by evrencoskun on 11/06/2017.
 */

public class TableViewAdapter extends AbstractTableAdapter<ColumnHeader, RowHeader, Cell> {

    private static final String LOG_TAG = TableViewAdapter.class.getSimpleName();
    // For testing purpose
    private int m_nId = 0;

    public TableViewAdapter(Context p_jContext) {
        super(p_jContext);

    }

    @Override
    public RecyclerView.ViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(m_jContext).inflate(R.layout.table_view_cell_layout,
                parent, false);

        CellViewHolder cellViewHolder = new CellViewHolder(layout);
        //cellViewHolder.itemView.setId(m_nId);

        //m_nId++;
        return cellViewHolder;
    }

    @Override
    public void onBindCellViewHolder(AbstractViewHolder holder, Object p_jValue, int
            p_nXPosition, int p_nYPosition) {
        Cell cell = (Cell) p_jValue;
        if (null == holder || !(holder instanceof CellViewHolder) || cell == null) {
            return;
        }

        CellViewHolder viewHolder = (CellViewHolder) holder;
        viewHolder.cell_container.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        viewHolder.cell_container.setTag(cell);
        viewHolder.cell_textview.setText(cell.getData());
        // TODO: remove unnecessary code line.
        viewHolder.cell_textview.requestLayout();
        viewHolder.cell_container.requestLayout();
        viewHolder.itemView.requestLayout();
    }

    @Override
    public RecyclerView.ViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(m_jContext).inflate(R.layout
                .table_view_column_header_layout, parent, false);

        return new ColumnHeaderViewHolder(layout);
    }

    @Override
    public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, Object p_jValue, int
            position) {
        ColumnHeader columnHeader = (ColumnHeader) p_jValue;

        if (null == holder || !(holder instanceof ColumnHeaderViewHolder) || columnHeader == null) {
            return;
        }

        ColumnHeaderViewHolder columnHeaderViewHolder = (ColumnHeaderViewHolder) holder;
        columnHeaderViewHolder.column_header_container.getLayoutParams().width = LinearLayout
                .LayoutParams.WRAP_CONTENT;
        columnHeaderViewHolder.column_header_textview.setText(columnHeader.getData());
        // TODO: remove unnecessary code line.
        columnHeaderViewHolder.column_header_textview.requestLayout();
        columnHeaderViewHolder.column_header_container.requestLayout();
        columnHeaderViewHolder.itemView.requestLayout();

    }

    @Override
    public RecyclerView.ViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(m_jContext).inflate(R.layout
                .table_view_row_header_layout, parent, false);
        return new RowHeaderViewHolder(layout);
    }

    @Override
    public void onBindRowHeaderViewHolder(AbstractViewHolder holder, Object p_jValue, int
            position) {
        RowHeader rowHeader = (RowHeader) p_jValue;

        if (null == holder || !(holder instanceof RowHeaderViewHolder) || rowHeader == null) {
            return;
        }
        RowHeaderViewHolder rowHeaderViewHolder = (RowHeaderViewHolder) holder;
        rowHeaderViewHolder.row_header_textview.setText(rowHeader.getData());
    }


    @Override
    public View onCreateCornerView() {
        return LayoutInflater.from(m_jContext).inflate(R.layout.table_view_corner_layout, null);
    }

    @Override
    public int getColumnHeaderItemViewType(int position) {
        // TODO:
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        // TODO:
        return 0;
    }

    @Override
    public int getCellItemViewType(int position) {
        return 0;
    }
}
