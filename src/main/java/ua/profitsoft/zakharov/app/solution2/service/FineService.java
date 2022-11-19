package ua.profitsoft.zakharov.app.solution2.service;

import ua.profitsoft.zakharov.app.solution2.analytics.FineAnalytics;
import ua.profitsoft.zakharov.app.solution2.model.Fine;
import ua.profitsoft.zakharov.app.solution2.stream.JsonFineWriter;
import ua.profitsoft.zakharov.app.solution2.stream.SaxFineReader;
import java.util.List;
import java.util.Map;

public class FineService {
    private SaxFineReader saxFineReader;
    private JsonFineWriter jsonFineWriter;

    public FineService() {
        saxFineReader = new SaxFineReader();
        jsonFineWriter = new JsonFineWriter();
    }

    public List<Fine> getFinesFromXmlFiles() {
        return saxFineReader.getFinesFromXmlFiles();
    }

    public void writeAnalyticTypeToJsonFile(List<Fine> fineList) {
        Map<String, Double> analyticByFine = FineAnalytics.getTypeAnalyticsByFine(fineList);
        jsonFineWriter.writeFinesToJsonFile(analyticByFine);
    }

}
