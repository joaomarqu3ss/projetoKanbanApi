package br.com.kanbanboard.configurations;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.kanbanboard.dtos.TarefaKanbanRequestDto;
import br.com.kanbanboard.dtos.TarefaKanbanResponseDto;
import br.com.kanbanboard.entities.TarefaKanban;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();

        // RequestDto -> Entity
        mapper.addMappings(new PropertyMap<TarefaKanbanRequestDto, TarefaKanban>() {
            @Override
            protected void configure() {
                map().setTitulo(source.getTitulo());
                map().setDescricao(source.getDescricao());
                map().setResponsavel(source.getResponsavel());

                using(ctx -> {
                    try {
                        String data = (String) ctx.getSource();
                        return data != null ? new SimpleDateFormat("yyyy-MM-dd").parse(data) : null;
                    } catch (Exception e) {
                        return null;
                    }
                }).map(source.getDataPrevistaEntrega(), destination.getDataPrevistaEntrega());

                map().setIniciado(source.getIniciado());
                map().setFinalizado(source.getFinalizado());
            }
        });

        // Entity -> ResponseDto
        mapper.addMappings(new PropertyMap<TarefaKanban, TarefaKanbanResponseDto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setTitulo(source.getTitulo());
                map().setDescricao(source.getDescricao());
                map().setResponsavel(source.getResponsavel());

                using(ctx -> {
                    Date data = (Date) ctx.getSource();
                    return data != null ? new SimpleDateFormat("yyyy-MM-dd").format(data) : null;
                }).map(source.getDataCriacao(), destination.getDataCriacao());

                using(ctx -> {
                    Date data = (Date) ctx.getSource();
                    return data != null ? new SimpleDateFormat("yyyy-MM-dd").format(data) : null;
                }).map(source.getDataPrevistaEntrega(), destination.getDataPrevistaEntrega());

                map().setIniciado(source.getIniciado());
                map().setFinalizado(source.getFinalizado());
            }
        });

        return mapper;
    }
}
