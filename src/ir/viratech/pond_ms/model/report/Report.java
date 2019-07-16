package ir.viratech.pond_ms.model.report;

import ir.viratech.pond_ms.model.report.base.BaseReport;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by amir on 9/7/17.
 */
public class Report extends BaseReport {

    private static final long serialVersionUID = 1L;

    public Report() {super();}

    @PostConstruct
    @Override
    public void init() {
        this.setCreationDate(new Date());
    }

    private String text;
    private int rate;
    private int counter;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", rate=" + rate +
                ", counter=" + counter +
                ", id=" + getId() +
                ", uid=" + getUid() +
                '}';
    }
}
