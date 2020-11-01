package com.teste.pismo.enums;

import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OperationTypeEnum {
	
	COMPRA_A_VISTA(1, "COMPRA A VISTA"),
	COMPRA_PARCELADA(2, "COMPRA PARCELADA"),
	SAQUE(3, "SAQUE"),
	PAGAMENTO(4, "PAGAMENTO");
	
	private Integer id;
	private String descricao;
	
	private OperationTypeEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	@JsonCreator
	public static OperationTypeEnum valueOfId(Integer id) {
		Optional<OperationTypeEnum> optional = Stream.of(values())
				.filter(operation -> id != null && operation != null && operation.id.compareTo(id) == 0)
				.findFirst();
		
		return (optional.isPresent()) ? optional.get() : null;
	}
	
	@JsonValue
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Converter
	public static class Mapper implements AttributeConverter<OperationTypeEnum, Integer> {

		@Override
		public Integer convertToDatabaseColumn(OperationTypeEnum operationTypeEnum) {
			return operationTypeEnum.getId();
		}

		@Override
		public OperationTypeEnum convertToEntityAttribute(Integer id) {
			return OperationTypeEnum.valueOfId(id);
		}
		
	}

}
