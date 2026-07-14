package com.curonex.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.curonex.ResourceTransfers;
import com.curonex.dao.ResourceTransferDAO;
import com.curonex.enums.TransferStatusEnum;
import com.curonex.exception.ResourceTransferDAOException;

public class ResourceTransferDAOImpl
        implements ResourceTransferDAO {

    private final Map<Long, ResourceTransfers>
            transferDatabase = new HashMap<>();

    @Override
    public ResourceTransfers addTransfer(
            ResourceTransfers transfer)
            throws ResourceTransferDAOException {

        try {

            if (transfer == null)
                throw new ResourceTransferDAOException(
                        "Transfer cannot be null");

            if (transferDatabase.containsKey(
                    transfer.getTransfer_id()))

                throw new ResourceTransferDAOException(
                        "Transfer ID already exists");

            transferDatabase.put(
                    transfer.getTransfer_id(),
                    transfer);

            return transfer;

        } catch (ResourceTransferDAOException e) {

            throw e;

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to add transfer",
                    e);
        }
    }

    @Override
    public ResourceTransfers getTransferById(
            long transferId)
            throws ResourceTransferDAOException {

        try {

            ResourceTransfers transfer =
                    transferDatabase.get(transferId);

            if (transfer == null)

                throw new ResourceTransferDAOException(
                        "Transfer not found");

            return transfer;

        } catch (ResourceTransferDAOException e) {

            throw e;

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to retrieve transfer",
                    e);
        }
    }

    @Override
    public List<ResourceTransfers> getAllTransfers()
            throws ResourceTransferDAOException {

        try {

            return new ArrayList<>(
                    transferDatabase.values());

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to retrieve transfers",
                    e);
        }
    }

    @Override
    public ResourceTransfers updateTransfer(
            ResourceTransfers transfer)
            throws ResourceTransferDAOException {

        try {

            if (!transferDatabase.containsKey(
                    transfer.getTransfer_id()))

                throw new ResourceTransferDAOException(
                        "Transfer not found");

            transferDatabase.put(
                    transfer.getTransfer_id(),
                    transfer);

            return transfer;

        } catch (ResourceTransferDAOException e) {

            throw e;

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to update transfer",
                    e);
        }
    }

    @Override
    public boolean deleteTransfer(long transferId)
            throws ResourceTransferDAOException {

        try {

            if (transferDatabase.remove(transferId)
                    == null)

                throw new ResourceTransferDAOException(
                        "Transfer not found");

            return true;

        } catch (ResourceTransferDAOException e) {

            throw e;

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to delete transfer",
                    e);
        }
    }

    @Override
    public List<ResourceTransfers>
            getTransfersByResource(long resourceId)
            throws ResourceTransferDAOException {

        try {

            return transferDatabase.values()
                    .stream()
                    .filter(t ->
                            t.getResource_id()
                                    == resourceId)
                    .toList();

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to retrieve transfers",
                    e);
        }
    }

    @Override
    public List<ResourceTransfers>
            getTransfersBySourceHospital(
                    long hospitalId)
            throws ResourceTransferDAOException {

        try {

            return transferDatabase.values()
                    .stream()
                    .filter(t ->
                            t.getSource_hospital_id()
                                    == hospitalId)
                    .toList();

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to retrieve transfers",
                    e);
        }
    }

    @Override
    public List<ResourceTransfers>
            getTransfersByDestinationHospital(
                    long hospitalId)
            throws ResourceTransferDAOException {

        try {

            return transferDatabase.values()
                    .stream()
                    .filter(t ->
                            t.getDestination_hospital_id()
                                    == hospitalId)
                    .toList();

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to retrieve transfers",
                    e);
        }
    }

    @Override
    public List<ResourceTransfers>
            getTransfersByStatus(
                    TransferStatusEnum status)
            throws ResourceTransferDAOException {

        try {

            return transferDatabase.values()
                    .stream()
                    .filter(t ->
                            t.getTransfer_status()
                                    == status)
                    .toList();

        } catch (Exception e) {

            throw new ResourceTransferDAOException(
                    "Unable to retrieve transfers",
                    e);
        }


    }
}
