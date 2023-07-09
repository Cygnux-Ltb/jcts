package io.cygnuxltb.console.persistence.dao;

import io.cygnuxltb.console.persistence.entity.TblMInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Instrument Repository
 *
 * @author yellow013
 */
@Repository
public interface InstrumentDao extends JpaRepository<TblMInstrument, Long> {

    /**
     * @param instrumentCode String
     * @return List<InstrumentEntity>
     */
    @Query("SELECT e FROM #{#entityName} e WHERE 1 = 1"
            + " AND e.instrumentCode LIKE :instrumentCode% "
    )
    List<TblMInstrument> queryBy(@Param("instrumentCode") String instrumentCode);

}
