package br.com.aliceraltecnologia.arquivoreaderjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aliceraltecnologia.arquivoreaderjob.reader.ArquivoClienteTransacaoReader;

@Configuration
public class ArquivoMultiplasLinhasStepConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Step leituraArquivoMultiplasLinhasStep(FlatFileItemReader leituraArquivoMultiplasLinhasReader, ItemWriter leituraArquivoMultiplasLinhasWriter) {
		return stepBuilderFactory
				.get("leituraArquivoMultiplasLinhasStep")
				.chunk(1)
				.reader(new ArquivoClienteTransacaoReader(leituraArquivoMultiplasLinhasReader))
				.writer(leituraArquivoMultiplasLinhasWriter)
				.build();
	}
}
