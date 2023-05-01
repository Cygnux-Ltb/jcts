/* Copyright (C) 2019 Interactive Brokers LLC. All rights reserved. This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */

package com.ib.apidemo;

import com.ib.apidemo.OrdersPanel.OrderRow;
import com.ib.apidemo.OrdersPanel.OrdersModel;
import com.ib.apidemo.TopModel.TopRow;
import com.ib.apidemo.util.HtmlButton;
import com.ib.apidemo.util.NewTabbedPanel;
import com.ib.apidemo.util.NewTabbedPanel.INewTab;
import com.ib.apidemo.util.TCombo;
import com.ib.apidemo.util.UpperField;
import com.ib.apidemo.util.VerticalPanel;
import com.ib.apidemo.util.VerticalPanel.HorzPanel;
import com.ib.client.ComboLeg;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.DeltaNeutralContract;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.Types.Action;
import com.ib.client.Types.SecType;
import com.ib.controller.ApiController.IContractDetailsHandler;
import com.ib.controller.ApiController.IEfpHandler;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;


public class ComboPanel extends JPanel implements INewTab {

    private final OrdersModel m_ordersModel = new OrdersModel() {
        @Serial
        private static final long serialVersionUID = -6026685865705817889L;

        @Override
        protected boolean shouldAdd(Contract contract, Order order, OrderState orderState) {
            return contract.isCombo();
        }
    };

    ComboPanel(MarketDataPanel parentPanel) {
        NewTabbedPanel tabs = new NewTabbedPanel();
        tabs.addTab("Spreads", new SpreadsPanel(parentPanel));
        tabs.addTab("EFP's", new EfpPanel(parentPanel));

        final JTable ordersTable = new JTable(m_ordersModel);
        JScrollPane ordersScroll = new JScrollPane(ordersTable);
        ordersScroll.setBorder(new TitledBorder("Live Combo Orders"));

        ordersTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    onDoubleClick(ordersTable.getSelectedRow());
                }
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(tabs);
        add(ordersScroll);
    }

    /**
     * Called when the tab is first visited.
     */
    @Override
    public void activated() {
        ApiDemo.INSTANCE.controller().reqLiveOrders(m_ordersModel);
    }

    /**
     * Called when the tab is closed by clicking the X.
     */
    @Override
    public void closed() {
    }

    protected void onDoubleClick(int row) {
        if (row != -1) {
            OrderRow order = m_ordersModel.get(row);
            TicketDlg dlg = new TicketDlg(order.m_contract, order.m_order);
            dlg.setVisible(true);
        }
    }

    static class SpreadsPanel extends JPanel {
        private final Contract m_contract = new Contract();
        private final TCombo<Action> m_action = new TCombo<>(Action.values());
        private final UpperField m_ratio = new UpperField("1");
        private final ContractPanel m_contractPanel = new ComboContractPanel();
        private final List<LegRow> m_legRows = new ArrayList<>();
        private final LegModel m_legsModel = new LegModel(m_legRows);
        private final JTable m_legsTable = new JTable(m_legsModel);
        private final TopModel m_mktDataModel;
        private final JTable m_mktDataTable;
        private DeltaNeutralContract m_dnContract;
        private final DnPanel m_dnPanel = new DnPanel();
        private final JLabel m_dnText = new JLabel();

        SpreadsPanel(MarketDataPanel parentPanel) {
            m_mktDataModel = new TopModel(parentPanel);
            m_mktDataTable = new JTable(m_mktDataModel);

            HtmlButton addLeg = new HtmlButton("Add Leg") {
                @Override
                protected void actionPerformed() {
                    onAddLeg();
                }
            };

            HtmlButton removeLeg = new HtmlButton("Remove Selected Leg") {
                @Override
                protected void actionPerformed() {
                    onRemoveLeg();
                }
            };

            HtmlButton removeLegs = new HtmlButton("Clear All Legs") {
                @Override
                protected void actionPerformed() {
                    onRemoveLegs();
                }
            };

            HtmlButton mktData = new HtmlButton("Request Market Data") {
                @Override
                protected void actionPerformed() {
                    onReqMktData();
                }
            };

            HtmlButton placeOrder = new HtmlButton("Place Order") {
                @Override
                protected void actionPerformed() {
                    onPlaceOrder();
                }
            };

            VerticalPanel buts = new VerticalPanel();
            buts.add(addLeg);
            buts.add(removeLeg);
            buts.add(mktData);
            buts.add(placeOrder);
            buts.add(Box.createVerticalStrut(10));
            buts.add(removeLegs);

            JScrollPane legsScroll = new JScrollPane(m_legsTable);
            legsScroll.setPreferredSize(new Dimension(100, 1));
            legsScroll.setBorder(new EmptyBorder(0, 0, 0, 0));

            JPanel legsPanel = new JPanel();
            legsPanel.setBorder(new TitledBorder("Combo Legs"));
            legsPanel.setLayout(new BorderLayout());
            legsPanel.add(legsScroll);
            legsPanel.add(m_dnText, BorderLayout.SOUTH);

            HorzPanel horzPanel = new HorzPanel();
            horzPanel.setBorder(new TitledBorder("Build Combo"));
            horzPanel.add(m_contractPanel);
            horzPanel.add(buts);
            horzPanel.add(legsPanel);
            horzPanel.add(m_dnPanel);

            JScrollPane mktDataScroll = new JScrollPane(m_mktDataTable);
            mktDataScroll.setBorder(new TitledBorder("Combo Market Data"));

            setLayout(new BorderLayout());
            add(horzPanel, BorderLayout.NORTH);
            add(mktDataScroll);
        }

        protected void onAddLeg() {
            m_contractPanel.onOK();
            ApiDemo.INSTANCE.controller().reqContractDetails(m_contract, list -> {
                for (ContractDetails details : list) {
                    addLeg(details);
                }
            });
        }

        protected void onRemoveLeg() {
            int[] indexes = m_legsTable.getSelectedRows();
            for (int i = indexes.length - 1; i >= 0; i--) {
                int index = indexes[i];
                m_legRows.remove(index);
            }
            m_legsModel.fireTableDataChanged();
        }

        protected void onRemoveLegs() {
            m_legRows.clear();
            m_legsModel.fireTableDataChanged();
        }

        protected void addLeg(ContractDetails contractDetails) {
            Contract c = contractDetails.contract();
            ComboLeg leg = new ComboLeg();
            leg.action(m_action.getSelectedItem());
            leg.ratio(m_ratio.getInt());
            leg.conid(c.conid());
            leg.exchange(c.exchange());

            LegRow row = new LegRow(c, leg);
            m_legRows.add(row);
            m_legsModel.fireTableDataChanged();
        }

        protected void onReqMktData() {
            Contract combo = getComboContractFromLegs();
            if (combo != null) {
                m_mktDataModel.addRow(getComboContractFromLegs());
            }
        }

        private Contract getComboContractFromLegs() {
            if (m_legRows.size() < 2) {
                return null;
            }

            LegRow leg = m_legRows.get(0);

            Contract comboContract = new Contract();
            comboContract.secType(SecType.BAG);
            comboContract.currency(leg.m_contract.currency());
            comboContract.exchange(leg.m_contract.exchange());
            comboContract.symbol(comboContract.exchange().equals("SMART")
                    ? leg.m_contract.currency()
                    : leg.m_contract.symbol());

            for (LegRow row : m_legRows) {
                comboContract.comboLegs().add(row.m_leg);
            }

            if (m_dnContract != null) {
                comboContract.deltaNeutralContract(m_dnContract);
            }

            return comboContract;
        }

        protected void onPlaceOrder() {
            Order o = new Order();
            o.totalQuantity(1);

            Contract c = getComboContractFromLegs();
            TicketDlg dlg = new TicketDlg(c, o);
            dlg.setVisible(true);
        }

        class ComboContractPanel extends ContractPanel {
            ComboContractPanel() {
                super(m_contract);
                removeAll();

                VerticalPanel p1 = new VerticalPanel();
                p1.setAlignmentY(0);
                p1.add("Action", m_action);
                p1.add("Ratio", m_ratio);
                p1.add("Symbol", m_symbol);
                p1.add("Sec type", m_secType);
                p1.add("Last trade date", m_lastTradeDateOrContractMonth);
                p1.add("Strike", m_strike);

                VerticalPanel p2 = new VerticalPanel();
                p2.setAlignmentY(0);
                p2.add("Put/call", m_right);
                p2.add("Multiplier", m_multiplier);
                p2.add("Exchange", m_exchange);
                p2.add("Comp. Exch.", m_compExch);
                p2.add("Currency", m_currency);
                p2.add("Local symbol", m_localSymbol);

                setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
                add(p1);
                add(p2);
            }
        }

        class DnPanel extends VerticalPanel {
            UpperField m_symbol = new UpperField();
            TCombo<SecType> m_secType = new TCombo<>(SecType.values());
            UpperField m_lastTradeDateOrContractMonth = new UpperField();
            UpperField m_exchange = new UpperField();
            UpperField m_currency = new UpperField();
            UpperField m_delta = new UpperField();
            UpperField m_price = new UpperField();

            DnPanel() {
                HtmlButton but = new HtmlButton("Set") {
                    @Override
                    protected void actionPerformed() {
                        onAdd();
                    }
                };

                setBorder(new TitledBorder("Delta-Neutral"));
                add("Symbol", m_symbol);
                add("Sec type", m_secType);
                add("Last trade date or contract month", m_lastTradeDateOrContractMonth);
                add("Exchange", m_exchange, but);
                add("Currency", m_currency);
                add("Delta", m_delta);
                add("Price", m_price);
            }

            protected void onAdd() {
                Contract dn = new Contract();
                dn.symbol(m_symbol.getText().toUpperCase());
                dn.secType(m_secType.getSelectedItem());
                dn.lastTradeDateOrContractMonth(m_lastTradeDateOrContractMonth.getText());
                dn.exchange(m_exchange.getText().toUpperCase());
                dn.currency(m_currency.getText().toUpperCase());

                ApiDemo.INSTANCE.controller().reqContractDetails(dn, list -> {
                    if (list.size() == 1) {
                        Contract c = list.get(0).contract();
                        m_dnContract = new DeltaNeutralContract(c.conid(), m_delta.getDouble(), m_price.getDouble());
                        m_dnText.setText(String.format("Delta-neutral: %s Delta: %s  Price: %s", c.description(), m_delta.getText(), m_price.getText()));
                    } else {
                        ApiDemo.INSTANCE.show("DN description does not define a uniqe contract");
                        m_dnContract = null;
                        m_dnText.setText(null);
                    }
                });
            }
        }
    }

    static class EfpPanel extends JPanel {
        private final UpperField m_symbol = new UpperField("IBM");
        private final UpperField m_futExch = new UpperField("ONE");
        private final UpperField m_lastTradeDate = new UpperField("201309");
        private final UpperField m_stkExch = new UpperField("SMART");
        private final List<LegRow> m_legRows = new ArrayList<>();
        private final LegModel m_legsModel = new LegModel(m_legRows);
        private final JTable m_legsTable = new JTable(m_legsModel);
        private final EfpModel m_efpModel;
        private final JCheckBox m_divProt = new JCheckBox();

        EfpPanel(MarketDataPanel parentPanel) {
            m_efpModel = new EfpModel(parentPanel);

            HtmlButton addLeg = new HtmlButton("Create EFP") {
                @Override
                protected void actionPerformed() {
                    onCreateEfp();
                }
            };

            HtmlButton mktData = new HtmlButton("Request Market Data") {
                @Override
                protected void actionPerformed() {
                    onReqMktData();
                }
            };

            HtmlButton placeOrder = new HtmlButton("Place Order") {
                @Override
                protected void actionPerformed() {
                    onPlaceOrder();
                }
            };

            VerticalPanel params = new VerticalPanel();
            params.add("Symbol", m_symbol);
            params.add("Futures exchange", m_futExch);
            params.add("Last trade date or contract month", m_lastTradeDate);
            params.add("Stock exchange", m_stkExch);
            params.add("Dividend protected", m_divProt);

            VerticalPanel buts = new VerticalPanel();
            buts.add(addLeg);
            buts.add(mktData);
            buts.add(placeOrder);

            JScrollPane legsScroll = new JScrollPane(m_legsTable);
            legsScroll.setPreferredSize(new Dimension(100, 1));
            legsScroll.setBorder(new TitledBorder("Combo Legs"));

            HorzPanel horzPanel = new HorzPanel();
            horzPanel.setBorder(new TitledBorder("Build Combo"));
            horzPanel.add(params);
            horzPanel.add(buts);
            horzPanel.add(legsScroll);

            JTable efpTable = new JTable(m_efpModel);
            JScrollPane efpScroll = new JScrollPane(efpTable);
            efpScroll.setBorder(new TitledBorder("EFP Market Data"));

            setLayout(new BorderLayout());
            add(horzPanel, BorderLayout.NORTH);
            add(efpScroll);
        }

        protected void onCreateEfp() {
            m_legRows.clear();
            m_legsModel.fireTableDataChanged();

            Contract fut = new Contract();
            fut.symbol(m_symbol.getText());
            fut.secType(SecType.FUT);
            fut.exchange(m_futExch.getText());
            fut.lastTradeDateOrContractMonth(m_lastTradeDate.getText());
            fut.currency("USD");

            ApiDemo.INSTANCE.controller().reqContractDetails(fut, new IContractDetailsHandler() {
                @Override
                public void contractDetails(List<ContractDetails> list) {
                    // if two futures are returned, assume that the first is is no div prot and the
                    // second one is div prot; unfortunately TWS does not send down the div prot flag
                    if (list.size() == 2) {
                        int i = m_divProt.isSelected() ? 1 : 0;
                        addFutLeg(list.get(i));
                    } else if (list.size() != 1) {
                        ApiDemo.INSTANCE.show("Request does not define a valid unique futures contract");
                    } else {
                        addFutLeg(list.get(0));
                    }
                }

                void addFutLeg(ContractDetails details) {
                    addLeg(details.contract(), Action.BUY, 1);
                }
            });

            Contract stk = new Contract();
            stk.symbol(m_symbol.getText());
            stk.secType(SecType.STK);
            stk.exchange(m_stkExch.getText());
            stk.currency("USD");

            ApiDemo.INSTANCE.controller().reqContractDetails(stk, list -> {
                for (ContractDetails data : list) {
                    addLeg(data.contract(), Action.SELL, 100);
                }
            });
        }

        protected void addLeg(Contract contract, Action action, int ratio) {
            ComboLeg leg = new ComboLeg();
            leg.action(action);
            leg.ratio(ratio);
            leg.conid(contract.conid());
            leg.exchange(contract.exchange());

            LegRow row = new LegRow(contract, leg);
            m_legRows.add(row);
            m_legsModel.fireTableDataChanged();
        }

        protected void onRemoveLeg() {
            int i = m_legsTable.getSelectedRow();
            if (i != -1) {
                m_legRows.remove(i);
                m_legsModel.fireTableDataChanged();
            }
        }

        protected void onReqMktData() {
            m_efpModel.addRow(getComboContractFromLegs());
        }

        private Contract getComboContractFromLegs() {
            if (m_legRows.size() < 2) {
                return null;
            }

            LegRow leg = m_legRows.get(0);

            Contract comboContract = new Contract();
            comboContract.secType(SecType.BAG);
            comboContract.currency(leg.m_contract.currency());
            comboContract.exchange("SMART");
            comboContract.symbol("USD");

            for (LegRow row : m_legRows) {
                comboContract.comboLegs().add(row.m_leg);
            }

            return comboContract;
        }

        protected void onPlaceOrder() {
            Order o = new Order();
            o.totalQuantity(1);

            Contract c = getComboContractFromLegs();
            TicketDlg dlg = new TicketDlg(c, o);
            dlg.setVisible(true);
        }

        static class EfpModel extends AbstractTableModel {
            @Serial
            private static final long serialVersionUID = -2542674072339659064L;
            List<EfpRow> m_rows = new ArrayList<>();
            MarketDataPanel m_parentPanel;

            EfpModel(MarketDataPanel parentPanel) {
                m_parentPanel = parentPanel;
            }

            void addRow(Contract contract) {
                EfpRow row = new EfpRow(this, contract.description(), m_parentPanel);
                m_rows.add(row);
                ApiDemo.INSTANCE.controller().reqEfpMktData(contract, "", false, false, row);
                fireTableRowsInserted(m_rows.size() - 1, m_rows.size() - 1);
            }

            @Override
            public int getRowCount() {
                return m_rows.size();
            }

            @Override
            public int getColumnCount() {
                return 10;
            }

            @Override
            public String getColumnName(int col) {
                return switch (col) {
                    case 0 -> "Description";
                    case 1 -> "Bid";
                    case 2 -> "Ask";
                    case 3 -> "Basis Points";
                    case 4 -> "Formatted";
                    case 5 -> "Implied Future";
                    case 6 -> "Hold Days";
                    case 7 -> "Future Expiry";
                    case 8 -> "Dividend Impact";
                    case 9 -> "Dividends to Expiry";
                    default -> null;
                };
            }

            @Override
            public Object getValueAt(int rowIn, int col) {
                EfpRow row = m_rows.get(rowIn);
                return switch (col) {
                    case 0 -> row.m_description;
                    case 1 -> row.m_bid;
                    case 2 -> row.m_ask;
                    case 3 -> row.m_basisPoints;
                    case 4 -> row.m_formattedBasisPoints;
                    case 5 -> row.m_impliedFuture;
                    case 6 -> row.m_holdDays;
                    case 7 -> row.m_futureLastTradeDate;
                    case 8 -> row.m_dividendImpact;
                    case 9 -> row.m_dividendsToLastTradeDate;
                    default -> null;
                };
            }

            static class EfpRow extends TopRow implements IEfpHandler {
                double m_basisPoints;
                String m_formattedBasisPoints;
                double m_impliedFuture;
                int m_holdDays;
                String m_futureLastTradeDate;
                double m_dividendImpact;
                double m_dividendsToLastTradeDate;

                EfpRow(AbstractTableModel model, String description, MarketDataPanel parentPanel) {
                    super(model, description, parentPanel);
                }

                @Override
                public void tickEFP(int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays, String futureLastTradeDate, double dividendImpact, double dividendsToLastTradeDate) {
                    m_basisPoints = basisPoints;
                    m_formattedBasisPoints = formattedBasisPoints;
                    m_impliedFuture = impliedFuture;
                    m_holdDays = holdDays;
                    m_futureLastTradeDate = futureLastTradeDate;
                    m_dividendImpact = dividendImpact;
                    m_dividendsToLastTradeDate = dividendsToLastTradeDate;

                    m_model.fireTableDataChanged();
                }
            }
        }
    }

    static class LegRow {
        Contract m_contract;
        ComboLeg m_leg;

        LegRow(Contract c, ComboLeg leg) {
            m_contract = c;
            m_leg = leg;
        }
    }

    static class LegModel extends AbstractTableModel {

        @Serial
        private static final long serialVersionUID = 1769615432224400289L;
        List<LegRow> m_legRows;

        LegModel(List<LegRow> legRows) {
            m_legRows = legRows;
        }

        @Override
        public int getRowCount() {
            return m_legRows.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int col) {
            return switch (col) {
                case 0 -> "Action";
                case 1 -> "Ratio";
                case 2 -> "Description";
                default -> null;
            };
        }

        @Override
        public Object getValueAt(int rowIn, int col) {
            LegRow row = m_legRows.get(rowIn);
            return switch (col) {
                case 0 -> row.m_leg.action();
                case 1 -> row.m_leg.ratio();
                case 2 -> row.m_contract.description();
                default -> null;
            };
        }
    }
}
