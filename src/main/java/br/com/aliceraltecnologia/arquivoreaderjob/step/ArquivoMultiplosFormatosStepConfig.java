package br.com.aliceraltecnologia.arquivoreaderjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosStepConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Step leituraArquivoMultiplosFormatosStep(FlatFileItemReader leituraArquivoMultiplosFormatosReader, ItemWriter leituraArquivoMultiplosFormatosWriter) {
		return stepBuilderFactory
				.get("leituraArquivoMultiplosFormatosStep")
				.chunk(1)
				.reader(leituraArquivoMultiplosFormatosReader)
				.writer(leituraArquivoMultiplosFormatosWriter)
				.build();
	}
}
