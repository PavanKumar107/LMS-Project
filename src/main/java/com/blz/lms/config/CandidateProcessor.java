package com.blz.lms.config;
import org.springframework.batch.item.ItemProcessor;
import com.blz.lms.model.CandidateModel;

public class CandidateProcessor implements ItemProcessor<CandidateModel,CandidateModel> {

    @Override
    public CandidateModel process(CandidateModel candidateModel) throws Exception {
        if(candidateModel.getStatus().equals("Completed")) {
            return candidateModel;
        }else{
            return null;
        }
    }
}