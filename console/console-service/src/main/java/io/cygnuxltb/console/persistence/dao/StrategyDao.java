package io.cygnuxltb.console.persistence.dao;

import io.cygnuxltb.console.persistence.entity.TbtStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Strategy Repository
 *
 * @author yellow013
 */
@Repository
public interface StrategyDao extends JpaRepository<TbtStrategy, Long> {

    /**
     * @param strategyId int
     * @return StrategyEntity
     */
    TbtStrategy queryByStrategyId(int strategyId);

    /**
     * @param strategyName String
     * @return StrategyEntity
     */
    TbtStrategy queryByStrategyName(String strategyName);

}