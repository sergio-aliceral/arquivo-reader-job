package br.com.aliceraltecnologia.arquivoreaderjob.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoMultiplosFormatosReaderConfig {

	@Bean
	@StepScope
	@SuppressWarnings({"rawtypes", "unchecked"})
	public FlatFileItemReader leituraArquivoMultiplosFormatosReader(@Value("#{jobParameters['arquivoClientesMultiplosFormatos']}") Resource arquivoClientesMultiplosFormatos, LineMapper lineMapper) {
		return new FlatFileItemReaderBuilder<>()
				.name("leituraArquivoMultiplosFormatosReader")
				.resource(arquivoClientesMultiplosFormatos)
				.lineMapper(lineMapper)
				.build();
	}
}
