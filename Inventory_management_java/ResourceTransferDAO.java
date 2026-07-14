package com.curonex.dao;

import java.util.List;

import com.curonex.ResourceTransfers;
import com.curonex.enums.TransferStatusEnum;
import com.curonex.exception.ResourceTransferDAOException;

public interface ResourceTransferDAO {

    ResourceTransfers addTransfer(ResourceTransfers transfer)
            throws ResourceTransferDAOException;

    ResourceTransfers getTransferById(long transferId)
            throws ResourceTransferDAOException;

    List<ResourceTransfers> getAllTransfers()
            throws ResourceTransferDAOException;

    ResourceTransfers updateTransfer(ResourceTransfers transfer)
            throws ResourceTransferDAOException;

    boolean deleteTransfer(long transferId)
            throws ResourceTransferDAOException;

    List<ResourceTransfers> getTransfersByResource(long resourceId)
            throws ResourceTransferDAOException;

    List<ResourceTransfers> getTransfersBySourceHospital(long hospitalId)
            throws ResourceTransferDAOException;

    List<ResourceTransfers> getTransfersByDestinationHospital(long hospitalId)
            throws ResourceTransferDAOException;

    List<ResourceTransfers> getTransfersByStatus(
            TransferStatusEnum status)
            throws ResourceTransferDAOException;
}
